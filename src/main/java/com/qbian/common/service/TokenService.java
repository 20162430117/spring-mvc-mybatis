package com.qbian.common.service;

import com.qbian.common.enums.MessageEnum;
import com.qbian.common.exception.ExternalServiceException;
import org.springframework.stereotype.Component;

/**
 * 校验 token 是否登录
 * Created by qbian on 17/4/22.
 */
@Component
public class TokenService {

    /**
     * 校验授权 token
     * @param token
     */
    public void checkUserLogin(String token) {
        // TODO 这里的鉴权逻辑自己实现
        if(!"123456".equals(token)) {
            throw new ExternalServiceException(MessageEnum.TOKEN_INVALID);
        }

    }

}
