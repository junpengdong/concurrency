package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotation.Recommend;
import com.mmall.concurrency.annotation.ThreadSafe;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 10:20
 * @Description: 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法只被调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
