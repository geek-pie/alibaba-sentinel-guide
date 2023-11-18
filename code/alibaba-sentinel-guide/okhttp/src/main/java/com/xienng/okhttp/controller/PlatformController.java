package com.xienng.okhttp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("platform")
public class PlatformController {

    @GetMapping(value = "do")
    public String query() {
        System.out.println("platform/do开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
