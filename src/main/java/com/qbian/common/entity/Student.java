package com.qbian.common.entity;

import com.qbian.common.annotation.Now;
import com.qbian.common.annotation.UUID;

import java.util.Date;

/**
 * 学生实体类
 * Created by qbian on 17/4/22.
 */
public class Student {

    /**
     * 主键
     */
    @UUID
    private String id;

    /**
     * 创建时间
     */
    @Now
    private Date createTime;
    /**
     * 更新时间
     */
    @Now(type="U")
    private Date updateTime;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
