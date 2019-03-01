package com.mmall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mmall.concurrency.annotation.ThreadSafe;

import java.util.List;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 10:31
 * @Description:
 */
@ThreadSafe
public class ImmutableExample3 {

    private final  static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final  static List<Integer> list2 = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        list.add(4);
        set.add(4);
    }
}
