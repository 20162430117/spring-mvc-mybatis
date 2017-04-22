package com.qbian.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.dto.ResponseDto;
import com.qbian.common.enums.MessageEnum;
import com.qbian.common.exception.ExternalServiceException;
import com.qbian.common.factory.BeanFactoryUtil;
import com.qbian.common.service.IBaseService;
import com.qbian.common.util.CheckUtil;
import com.qbian.common.util.ResponseUtil;
import com.qbian.common.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 核心控制器，处理所有请求
 * Created by qbian on 17/4/22.
 */
@Controller
public class ExternalController {

    private final Logger LOG = LoggerFactory.getLogger(ExternalController.class);

    @RequestMapping(value = "/externalservice/{service}")
    @ResponseBody
    public String executeExternalService(@PathVariable String service
                , @RequestBody String params
                , HttpServletRequest request
                , HttpServletResponse response) throws IOException {
        // 跨域访问用
        response.addHeader("Access-Control-Allow-Origin", "*");
        // 请求 ID
        String uuid = StringUtil.getUUIDString();
        LOG.info("request({}):service={}, params={}", new Object[]{uuid, service, params});
        ResponseDto rspDto = null;
        String rspStr = "";

        try {
            JSONObject paramObj = CheckUtil.parseObject(params);
            IBaseService baseService = (IBaseService) BeanFactoryUtil.getBean(service);
            rspDto = baseService.process(paramObj, request, response);

        } catch (RecoverableDataAccessException e) {
            LOG.error("［ 数据库异常 ］", e);

            rspDto = ResponseUtil.error(MessageEnum.DATABASE_ERROR);
        } catch (DataAccessResourceFailureException e) {
            LOG.error("［ 数据库异常 ］", e);

            rspDto = ResponseUtil.error(MessageEnum.DATABASE_ERROR);
        } catch (BeansException e) {

            rspDto = ResponseUtil.error(MessageEnum.SERVICE_NOT_EXIST);
        } catch (ExternalServiceException e) {

            rspDto = ResponseUtil.error(e.getMessageEnum());
        } catch (Throwable e) {
            LOG.error("［ 系统异常 ］", e);

            rspDto = ResponseUtil.error(MessageEnum.SYSTEM_ERROR);
        } finally {
            rspStr = rspDto.toString();
            LOG.info("response({}):{}", uuid, rspStr);
        }

        return rspStr;
    }

}
