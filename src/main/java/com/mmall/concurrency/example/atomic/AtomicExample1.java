package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/2/28 15:37
 * @Description:
 */
@Slf4j
@ThreadSafe
public class AtomicExample1 {

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
    public static AtomicInteger count = new AtomicInteger(0);

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
                    add();
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
        log.info("Count：{}", count.get());
    }

    private static void add() {

        // 先执行加一操作再获取值
        count.incrementAndGet();

        // 先获取值再执行加一操作
//        count.getAndIncrement();
    }
}
