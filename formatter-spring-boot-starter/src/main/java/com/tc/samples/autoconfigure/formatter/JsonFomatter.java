package com.tc.samples.autoconfigure.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author woshi
 * @date 2021/1/28
 */
public class JsonFomatter implements Formatter {
    private final ObjectMapper objectMapper;

    public JsonFomatter() {
        this(new ObjectMapper());
    }

    public JsonFomatter( ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }
}