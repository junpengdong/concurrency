package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.NotRecommend;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:59
 * @Description: 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    private SingletonExample3() {

    }

    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
