package com.qbian.other.service;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dto.ResponseDto;
import com.qbian.common.entity.Student;
import com.qbian.common.service.BaseService;
import com.qbian.common.service.TokenService;
import com.qbian.common.util.CheckUtil;
import com.qbian.common.util.ResponseUtil;
import com.qbian.other.dao.StudentExtDao;
import com.qbian.other.dto.QueryStudentSexPageDto;
import com.qbian.other.dto.StudentPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 根据 sex 分页查询
 * Created by qbian on 17/4/22.
 */
@Service("queryStudentBySex")
public class QueryStudentBySexService  extends BaseService<StudentPageDto> {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentExtDao studentExtDao;

    @Override
    public ResponseDto<StudentPageDto> process(JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        // 校验请求参数
        CheckUtil.checkEmpty(params, "token", "sex", "pageNo", "pageSize");
        // 校验 token
        tokenService.checkUserLogin(params.getString("token"));

        // 根据性别分页查询 Student，查询总数会自动封装到pageDto对象上
        QueryStudentSexPageDto pageDto = JSONObject.parseObject(params.toJSONString(), QueryStudentSexPageDto.class);

        List<Student> students = studentExtDao.queryBySexWithPage(pageDto);

        StudentPageDto studentPageDto = new StudentPageDto();
        // 查询总数会自动封装到pageDto对象上
        studentPageDto.setTotalSize(pageDto.getTotalSize());
        studentPageDto.setStudents(students);

        return ResponseUtil.success(studentPageDto);
    }

}
