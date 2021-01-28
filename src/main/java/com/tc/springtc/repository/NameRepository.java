package com.tc.springtc.repository;

import com.tc.springtc.annotation.StringRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author woshi
 * @date 2021/1/7
 */
@StringRepository("chineseNameRepository")
public class NameRepository {
    public List<String> findAll(){
        return Arrays.asList("张三","Tom","李四");
    }
}