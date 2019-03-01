package com.mmall.concurrency.controller;

import com.mmall.concurrency.example.threadlocal.RequestHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Mr.Dong
 * @Date: 2019/3/1 14:55
 * @Description:
 */
@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("test")
    public Long test() {
        return RequestHolder.getId();
    }
}
