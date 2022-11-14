package com.noodles.springframework.core.convert.support;

import com.noodles.springframework.core.convert.ConversionService;
import com.noodles.springframework.core.convert.converter.Converter;
import com.noodles.springframework.core.convert.converter.ConverterFactory;
import com.noodles.springframework.core.convert.converter.ConverterRegistry;
import com.noodles.springframework.core.convert.converter.GenericConverter;
import com.noodles.springframework.core.convert.converter.GenericConverter.ConvertiblePair;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 通用转换服务
 * @author: liuxian
 * @date: 2022-11-14 22:02
 */
public class GenericConversionService implements ConversionService, ConverterRegistry {

    private Map<ConvertiblePair, GenericConverter> converters = new HashMap<>();

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        GenericConverter converter = getConverter(sourceType, targetType);
        return converter != null;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        Class<?> sourceType = source.getClass();
        GenericConverter converter = getConverter(sourceType, targetType);
        return (T)converter.convert(source, sourceType, targetType);
    }

    @Override
    public void addConverter(Converter<?, ?> converter) {
        ConvertiblePair typeInfo = getRequiredTypeInfo(converter);
        ConverterAdapter converterAdapter = new ConverterAdapter(typeInfo, converter);
        for (ConvertiblePair convertibleType : converterAdapter.geConvertibleTypes()) {
            converters.put(convertibleType, converterAdapter);
        }
    }

    @Override
    public void addConverter(GenericConverter converter) {
        for (ConvertiblePair convertibleType : converter.geConvertibleTypes()) {
            converters.put(convertibleType, converter);
        }
    }

    @Override
    public void addConverterFactory(ConverterFactory<?, ?> converterFactory) {
        ConvertiblePair typeInfo = getRequiredTypeInfo(converterFactory);
        ConverterFactoryAdapter converterFactoryAdapter = new ConverterFactoryAdapter(typeInfo, converterFactory);
        for (ConvertiblePair convertibleType : converterFactoryAdapter.geConvertibleTypes()) {
            converters.put(convertibleType, converterFactoryAdapter);
        }
    }

    protected GenericConverter getConverter(Class<?> sourceType, Class<?> targetType) {
        List<Class<?>> sourceCandidates = getClassHierarchy(sourceType);
        List<Class<?>> targetCandidates = getClassHierarchy(targetType);
        for (Class<?> sourceCandidate : sourceCandidates) {
            for (Class<?> targetCandidate : targetCandidates) {
                ConvertiblePair convertiblePair = new GenericConverter.ConvertiblePair(sourceCandidate, targetCandidate);
                GenericConverter converter = converters.get(convertiblePair);
                if (converter != null) {
                    return converter;
                }
            }
        }
        return null;
    }

    private List<Class<?>> getClassHierarchy(Class<?> clazz) {
        List<Class<?>> hierarchy = new ArrayList<>();
        while (clazz != null) {
            hierarchy.add(clazz);
            clazz = clazz.getSuperclass();
        }
        return hierarchy;
    }

    private ConvertiblePair getRequiredTypeInfo(Object object) {
        Type[] types = object.getClass().getGenericInterfaces();
        ParameterizedType parameterized = (ParameterizedType) types[0];
        Type[] actualTypeArguments = parameterized.getActualTypeArguments();
        Class sourceType = (Class)actualTypeArguments[0];
        Class targetType = (Class)actualTypeArguments[1];
        return new ConvertiblePair(sourceType, targetType);
    }

    private final class ConverterAdapter implements GenericConverter {

        private final ConvertiblePair typeInfo;

        private final Converter<Object, Object> converter;

        public ConverterAdapter(ConvertiblePair typeInfo, Converter<?, ?> converter) {
            this.typeInfo = typeInfo;
            this.converter = (Converter<Object, Object>) converter;
        }

        @Override
        public Set<ConvertiblePair> geConvertibleTypes() {
            return Collections.singleton(typeInfo);
        }

        @Override
        public Object convert(Object source, Class sourceType, Class targetType) {
            return converter.convert(source);
        }
    }

    private final class ConverterFactoryAdapter implements GenericConverter {

        private final ConvertiblePair typeInfo;

        private final ConverterFactory<Object, Object> converterFactory;

        public ConverterFactoryAdapter(ConvertiblePair typeInfo, ConverterFactory<?, ?> converterFactory) {
            this.typeInfo = typeInfo;
            this.converterFactory = (ConverterFactory<Object, Object>) converterFactory;
        }


        @Override
        public Set<ConvertiblePair> geConvertibleTypes() {
            return Collections.singleton(typeInfo);
        }

        @Override
        public Object convert(Object source, Class sourceType, Class targetType) {
            return converterFactory.getConverter(targetType).convert(source);
        }
    }
}
