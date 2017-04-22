package com.qbian.other.dao;

import com.qbian.common.entity.Student;
import com.qbian.other.dto.QueryStudentSexPageDto;

import java.util.List;

/**
 * Created by qbian on 17/4/22.
 */
public interface StudentExtDao {

    /**
     * 根据 sex 查询分页 student
     * @param pageDto QueryStudentSexPageDto
     * @return List<Student>
     */
    List<Student> queryBySexWithPage(QueryStudentSexPageDto pageDto);
}
