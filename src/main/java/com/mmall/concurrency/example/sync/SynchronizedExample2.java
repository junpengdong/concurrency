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
public class SynchronizedExample2 {

    // 修饰一个类，称为同步代码块，作用作用：当前类的所有对象
    public static void test1(int flag) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1_{} -> {}", flag, i);
            }
        }
    }

    // 修饰一个静态方法，称位同步方法，作用对象：当前类的所有对象
    public static synchronized void test2(int flag) {
        for (int i = 0; i < 10; i++) {
            log.info("test2_{} -> {}", flag, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
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
