package com.qbian.common.exception;

import com.qbian.common.enums.MessageEnum;

/**
 * 业务相关异常
 * Created by qbian on 17/4/22.
 */
public class ExternalServiceException extends RuntimeException {

    private MessageEnum messageEnum;

    public ExternalServiceException(MessageEnum messageEnum) {
        super(messageEnum.getMsg());
        this.messageEnum = messageEnum;
    }

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }
}
