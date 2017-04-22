package com.qbian.common.util;

import com.qbian.common.dto.ResponseDto;
import com.qbian.common.enums.MessageEnum;

/**
 * 响应数据工具类
 * Created by qbian on 17/4/22.
 */
public class ResponseUtil {

    private ResponseUtil() {}

    /**
     * 无响应数据的返回对象
     * @return
     */
    public static ResponseDto success() {
        return new ResponseDto(MessageEnum.SUCCESS);
    }

    /**
     * 有响应数据的返回对象
     * @return
     */
    public static ResponseDto success(Object data) {
        ResponseDto responseDto = new ResponseDto(MessageEnum.SUCCESS);
        responseDto.setData(data);

        return responseDto;
    }

    /**
     * 返回异常
     * @return
     */
    public static ResponseDto error(MessageEnum messageEnum) {
        return new ResponseDto(messageEnum);
    }
}
