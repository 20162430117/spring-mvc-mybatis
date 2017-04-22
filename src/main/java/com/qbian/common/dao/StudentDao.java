package com.qbian.common.dao;

import com.qbian.common.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生数据库操作共通方法
 * Created by qbian on 17/4/22.
 */
public interface StudentDao {

    /**
     * 插入一条数据
     * @param student 待插入对象
     * @return
     */
    int insert(Student student);

    /**
     * 根据 key 查询数据
     * @param key 主键
     * @return
     */
    Student queryByKey(String key);

    /**
     * 根据 key 更新数据
     * @param student 待更新对象
     * @return
     */
    int updateByKey(Student student);

    /**
     * 根据 key 删除数据
     * @param key 主键
     * @return
     */
    int deleteByKey(String key);

    /**
     * 根据 field 查询据库中信息
     * @param fieldName 查询字段名
     * @param fieldValue 查询数值
     * @return
     */
    List<Student> queryByField(@Param("fieldName") String fieldName, @Param("fieldValue") String fieldValue);

}
