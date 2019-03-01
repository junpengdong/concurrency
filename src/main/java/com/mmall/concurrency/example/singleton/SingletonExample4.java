package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 懒汉模式 -> 双重同步锁单例模式
 */
@NotThreadSafe
public class SingletonExample4 {

    private static SingletonExample4 instance = null;

    private SingletonExample4() {

    }

    // instance = new SingletonExample4(); 实例化步骤
    // 1、分配对象内存空间
    // 2、初始化对象
    // 3、设置instance指向刚分配的内存

    // JVM和CPU优化，发生了指令重排
    // 1、分配对象内存空间
    // 3、设置instance指向刚分配的内存
    // 2、初始化对象

    // 静态的工厂方法
    public static SingletonExample4 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample4.class) { // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
