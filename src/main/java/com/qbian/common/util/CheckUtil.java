package com.qbian.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qbian.common.enums.MessageEnum;
import com.qbian.common.exception.ExternalServiceException;

import java.text.MessageFormat;

/**
 * 校验请求数据
 * Created by qbian on 17/4/22.
 */
public class CheckUtil {
    /**
     * 校验是否为JSON格式，请求参数为空返回NULL
     *
     * @param json
     * @return
     */
    public static JSONObject parseObject(String json) {
        // 参数为空的时候 默认检查成功
        if (StringUtil.isNotBlank(json)) {
            try {
                return JSON.parseObject(json);
            } catch (Exception e) {
                throw new ExternalServiceException(MessageEnum.JSON_PARSE_ERROR);
            }
        }

        return null;
    }

    /**
     * 必须 check 的请求字段
     * @param params 待 check 的数据
     * @param keys check 的参数数组
     */
    public static void checkEmpty(JSONObject params, String... keys) {
        StringBuilder sb  = new StringBuilder();
        if(params == null){
            MessageEnum messageEnum = MessageEnum.PARAMS_EMPTY_ERROR;
            String message = messageEnum.getMsg();
            message = MessageFormat.format(message, keys[0]);
            messageEnum.setMsg(message);

            throw new ExternalServiceException(messageEnum);
        }
        for (String key : keys) {
            String value = params.getString(key);
            if (StringUtil.isBlank(value)) {
                sb.append(",");
                sb.append(key);
            }
        }
        if (sb.length() > 0) {
            MessageEnum messageEnum = MessageEnum.PARAMS_EMPTY_ERROR;
            String message = messageEnum.getMsg();
            sb.delete(0, 1);
            message = MessageFormat.format(message, sb.toString());
            messageEnum.setMsg(message);

            throw new ExternalServiceException(messageEnum);
        }
    }


}
