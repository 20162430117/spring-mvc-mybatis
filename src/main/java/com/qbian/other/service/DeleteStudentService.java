package com.qbian.other.service;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dao.StudentDao;
import com.qbian.common.dto.ResponseDto;
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
 * 删除
 * Created by qbian on 17/4/22.
 */
@Service("deleteStudent")
public class DeleteStudentService extends BaseService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentDao studentDao;

    @Override
    public ResponseDto process(JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        // 校验请求参数
        CheckUtil.checkEmpty(params, "token", "id");
        // 校验 token
        tokenService.checkUserLogin(params.getString("token"));

        String uid = params.getString("id");

        int result = studentDao.deleteByKey(uid);
        if(result < 1) {
            throw new ExternalServiceException(MessageEnum.DELETE_EMPTY);
        }

        return ResponseUtil.success();
    }

}
