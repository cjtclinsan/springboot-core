package com.tc.samples.autoconfigure.formatter;

/**
 * @author woshi
 * @date 2021/1/28
 */
public interface Formatter {
    /**
     * 格式化操作
     * @param object  格式化对象
     * @return  返回格式化后的内容
     */
    String format(Object object);
}
