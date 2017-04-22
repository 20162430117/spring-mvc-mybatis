package com.qbian.other.dto;

import com.qbian.common.dto.PageInfoDto;

/**
 * 根据 sex 查询分页 student
 * Created by qbian on 17/4/22.
 */
public class QueryStudentSexPageDto  extends PageInfoDto {

    /** 根据性别分页查询 */
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
