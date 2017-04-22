package com.qbian.other.dto;

import com.qbian.common.entity.Student;

import java.util.List;

/**
 * Student 分页查询返回的结果集
 * Created by qbian on 17/4/22.
 */
public class StudentPageDto {

    /** 总页数 */
    private Integer totalSize;

    /** 返回的数据数组 */
    private List<Student> students;

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
