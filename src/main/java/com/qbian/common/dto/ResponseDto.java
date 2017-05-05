package com.qbian.common.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qbian.common.enums.MessageEnum;
import com.qbian.common.util.DateUtil;

/**
 * 响应数据模型
 * Created by qbian on 17/4/22.
 */
public class ResponseDto<T> {

    /** 响应状态码 */
    private Integer code;

    /** 响应消息 */
    private String msg;

    /** 响应数据 */
    private T data;

    public ResponseDto(MessageEnum messageEnum) {
        this.code = messageEnum.getCode();
        this.msg = messageEnum.getMsg();
        if(messageEnum.getCode() == MessageEnum.PARAMS_EMPTY_ERROR.getCode()) {
            String message = MessageEnum.PARAMS_EMPTY_ERROR.getMsg();
            MessageEnum.PARAMS_EMPTY_ERROR.setMsg(message.split(":")[0] + ": {0}");
        }
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, DateUtil.getSecondsFormatConfig(),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
