package com.qbian.common.handle;

import com.qbian.common.dto.ResponseDto;
import com.qbian.common.enums.MessageEnum;
import com.qbian.common.exception.ExternalServiceException;
import com.qbian.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理，这里用不到，所有异常都在 ExternalController 内处理了
 * Created by qbian on 17/4/22.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger LOG = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto handle(Exception e) {
        // 封装的业务错误
        if(e instanceof ExternalServiceException) {
            ExternalServiceException serviceException = (ExternalServiceException) e;

            return ResponseUtil.error(serviceException.getMessageEnum());
        }
        // 未知错误
        else {
            LOG.error("［ 系统错误 ］{}", e);

            return ResponseUtil.error(MessageEnum.SYSTEM_ERROR);
        }

    }

}
