package com.neo.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;


/**
 * @Description:
 * @author :******| xugp
 * @date ：2018年12月25日 上午10:32:04
 */

public class JacksonUtils {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String beanToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    public static ObjectMapper createObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //增加属性名全部转为小写
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
        return objectMapper;
    }

    public static <T> T jsonToBean(String json, Class<T> cls) throws IOException {
        if(StringUtils.isEmpty(json)){
            return null;
        }
        ObjectMapper objectMapper = createObjectMapper();
        return objectMapper.readValue(json, cls);
    }

    public static String mapToJson(Map<String, String> map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    public static String toPrettyString(final Object value) throws IOException {
        if(value == null){
            return null;
        }
        final ObjectMapper objectMapper = createObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
    }

    private JacksonUtils(){

    }
}
