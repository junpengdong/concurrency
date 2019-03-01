package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {

    private static SingletonExample1 instance = null;

    private SingletonExample1() {

    }

    // 静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
