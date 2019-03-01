package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annotation.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 10:31
 * @Description:
 */
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
    }
}
