package com.qbian.common.service;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dto.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有的接口 Service 都继承此
 * Created by qbian on 17/4/22.
 */
public abstract class BaseService<T> implements IBaseService<T> {

    /**
     * process 处理POST请求返回结果，包括返回码和返回码描述
     *
     * @param params 业务参数
     * @param request request对象
     * @param response response对象
     * @return 返回码及描述
     */
    public ResponseDto<T> process(JSONObject params
            , HttpServletRequest request
            , HttpServletResponse response) {

        return null;
    }

}
