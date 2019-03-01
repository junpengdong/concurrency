package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 10:31
 * @Description:
 */
public class ImmutableExample1 {

    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    private void test(final int a) {

    }
}
