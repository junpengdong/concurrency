package com.mmall.concurrency.example.commonUnsafe;

import com.mmall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 15:07
 * @Description:
 */
@Slf4j
@NotThreadSafe
public class StringExample1 {

    /**
     * 请求总数
     */
    public static int clientTotal = 5000;

    /**
     * 同时并发线程总数
     */
    public static int threadTotal = 200;

    /**
     * 计数
     */
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // 定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 定义信号量
        Semaphore semaphore = new Semaphore(threadTotal);

        // 定义计数器闭锁
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    // 先获取信号量
                    semaphore.acquire();
                    update();
                    // 释放信号量
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Catch Exception：{}", e);
                }
                // 执行完计数器减一
                countDownLatch.countDown();
            });
        }
        // 计数器闭锁等待所有线程执行完毕
        countDownLatch.await();
        executorService.shutdown();
        log.info("Size：{}", builder.length());
    }

    private static void update() {
        builder.append("1");
    }

}
