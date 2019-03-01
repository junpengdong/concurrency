package com.mmall.concurrency.example.singleton;


import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 饿汉模式
 */
@ThreadSafe
public class SingletonExample6 {

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    private SingletonExample6() {

    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }
}
