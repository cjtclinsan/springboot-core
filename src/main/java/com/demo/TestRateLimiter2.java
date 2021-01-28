package com.demo;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author woshi
 * @date 2021/1/14
 */
public class TestRateLimiter2 {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 20; i++) {
            long timeOut = (long) 0.9;

            boolean isValid = rateLimiter.tryAcquire(timeOut, TimeUnit.SECONDS);
            System.out.println("任务"+i+"执行是否有效:"+isValid);
            if( !isValid ){
                continue;
            }
            System.out.println("任务"+i+"在执行");
        }
        System.out.println("结束");
    }
}