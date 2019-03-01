package com.mmall.concurrency.example.singleton;


import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 饿汉模式
 */
@ThreadSafe
public class SingletonExample2 {

    private static SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2() {

    }

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
