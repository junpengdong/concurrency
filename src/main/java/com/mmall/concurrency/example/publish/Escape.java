package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annotation.NotRecommend;
import com.mmall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 09:52
 * @Description: 对象逸出
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    public class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
