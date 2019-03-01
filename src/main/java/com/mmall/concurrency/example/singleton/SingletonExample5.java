package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 懒汉模式 -> 双重同步锁单例模式
 */
@ThreadSafe
public class SingletonExample5 {

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    private SingletonExample5() {

    }

    // instance = new SingletonExample4(); 实例化步骤
    // 1、分配对象内存空间
    // 2、初始化对象
    // 3、设置instance指向刚分配的内存

    // 静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample5.class) { // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
