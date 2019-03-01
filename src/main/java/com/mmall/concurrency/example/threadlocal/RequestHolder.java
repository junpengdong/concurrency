package com.mmall.concurrency.example.threadlocal;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 11:33
 * @Description:
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
