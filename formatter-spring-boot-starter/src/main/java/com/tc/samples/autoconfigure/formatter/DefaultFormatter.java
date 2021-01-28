package com.tc.samples.autoconfigure.formatter;

/**
 * @author woshi
 * @date 2021/1/28
 */
public class DefaultFormatter implements Formatter {
    @Override
    public String format(Object object) {
        return String.valueOf(object);
    }
}