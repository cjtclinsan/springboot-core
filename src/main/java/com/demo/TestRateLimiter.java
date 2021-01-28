package com.demo;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author woshi
 * @date 2021/1/14
 */
public class TestRateLimiter {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            //该方法会阻塞线程，直到令牌桶中能取到令牌为止才继续向下执行
            double waitTime = rateLimiter.acquire();
            System.out.println("任务"+i+"等待时间:"+waitTime);
        }
        System.out.println("任务结束");
    }
}