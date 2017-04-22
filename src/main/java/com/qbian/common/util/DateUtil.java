package com.qbian.common.util;

import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.Calendar;

/**
 * Created by qbian on 17/4/22.
 */
public class DateUtil {

    private DateUtil(){}

    private static SerializeConfig secondsFormatConfig;

    static {
        secondsFormatConfig = new SerializeConfig();
        secondsFormatConfig.put(java.util.Date.class, new SecondsFormatSerializer());
        secondsFormatConfig.put(java.sql.Timestamp.class, new TimestampSecondsFormatSerializer());
    }

    /**
     *
     * 获取日期格式化输出解析配置
     *
     * @return secondsFormatConfig
     */
    public static SerializeConfig getSecondsFormatConfig() {
        return secondsFormatConfig;
    }
}
