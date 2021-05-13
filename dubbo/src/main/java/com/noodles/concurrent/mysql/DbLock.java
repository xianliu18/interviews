package com.noodles.concurrent.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noodles.concurrent.bean.LockRecord;
import com.noodles.mapper.LockRecordMapper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 基于 MySql 的分布式锁
 * @Author: noodles
 * @create: 2021-05-13 18:12
 */
@Component
public class DbLock implements Lock {

    private static final String LOCK_NAME = "db_lock_stock";

    @Autowired
    private LockRecordMapper lockRecordMapper;

    @Override
    public void lock() {
        while (true) {
            boolean b = tryLock();
            if (b) {
                // 添加记录
                LockRecord record = new LockRecord();
                record.setLockName(LOCK_NAME);
                lockRecordMapper.insert(record);
                return;
            } else {
                System.out.println("等待中....");
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        // 查询数据库
        QueryWrapper<LockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lock_name", LOCK_NAME);
        LockRecord record = lockRecordMapper.selectOne(queryWrapper);

        if (record == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        QueryWrapper<LockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lock_name", LOCK_NAME);
        lockRecordMapper.delete(queryWrapper);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
