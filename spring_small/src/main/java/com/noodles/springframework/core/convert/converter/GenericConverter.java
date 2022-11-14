package com.noodles.springframework.core.convert.converter;

import cn.hutool.core.lang.Assert;
import java.util.Set;

/**
 * @description: 通用的转换接口
 * @author: liuxian
 * @date: 2022-11-14 22:01
 */
public interface GenericConverter {

    Set<ConvertiblePair> geConvertibleTypes();

    Object convert(Object source, Class sourceType, Class targetType);

    final class ConvertiblePair {
        private final Class<?> sourceType;

        private final Class<?> targetType;

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            Assert.notNull(sourceType, "SourceType must not be null");
            Assert.notNull(targetType, "TargetType must not be null");
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return sourceType;
        }

        public Class<?> getTargetType() {
            return targetType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ConvertiblePair.class) {
                return false;
            }
            ConvertiblePair other = (ConvertiblePair)obj;
            return this.sourceType.equals(other.sourceType) && this.targetType.equals(other.targetType);
        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }

    }
}
