package com.noodles.concurrent.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Description: Mysql 中的实体锁
 * @Author: noodles
 * @create: 2021-05-13 18:14
 */
@TableName(value="lock_record")
public class LockRecord {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value="lock_name")
    private String lockName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }
}
