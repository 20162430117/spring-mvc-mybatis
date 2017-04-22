package com.qbian.other.service;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dao.StudentDao;
import com.qbian.common.dto.ResponseDto;
import com.qbian.common.entity.Student;
import com.qbian.common.enums.MessageEnum;
import com.qbian.common.exception.ExternalServiceException;
import com.qbian.common.service.BaseService;
import com.qbian.common.service.TokenService;
import com.qbian.common.util.CheckUtil;
import com.qbian.common.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据 ID 查询但条数据
 * Created by qbian on 17/4/22.
 */
@Service("findStudent")
public class FindStudentService extends BaseService<Student> {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentDao studentDao;

    @Override
    public ResponseDto<Student> process(JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        // 校验请求参数
        CheckUtil.checkEmpty(params, "token", "id");
        // 校验 token
        tokenService.checkUserLogin(params.getString("token"));

        String uid = params.getString("id");

        Student student = studentDao.queryByKey(uid);
        if(student == null) {
            throw new ExternalServiceException(MessageEnum.QUERY_EMPTY);
        }

        return ResponseUtil.success(student);
    }

}
