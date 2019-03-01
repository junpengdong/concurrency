package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/2/28 17:11
 * @Description:
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块，称为同步代码块，作用对象：同一个调用对象
    public void test1(int flag) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1_{} -> {}", flag, i);
            }
        }
    }

    // 修饰一个方法，称为同步方法，作用对象：同一个调用对象
    public synchronized void test2(int flag) {
        for (int i = 0; i < 10; i++) {
            log.info("test2_{} -> {}", flag, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizedExample1.test1(1);
        });
        executorService.execute(() -> {
            synchronizedExample1.test1(1);
        });

        executorService.execute(() -> {
            synchronizedExample1.test2(2);
        });
        executorService.execute(() -> {
            synchronizedExample1.test2(2);
        });
    }

    /*public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizedExample1.test1();
        });
        executorService.execute(() -> {
            synchronizedExample2.test1();
        });
    }*/
}
