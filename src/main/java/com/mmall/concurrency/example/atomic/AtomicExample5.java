package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * @Auther: Mr.Dong
 * @Date: 2019/2/28 15:37
 * @Description:
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    @Getter
    private volatile int count = 100;

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("Update Success：{}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("Update Success：{}", example5.getCount());
        }else {
            log.info("Update Field：{}", example5.getCount());
        }
    }
}
