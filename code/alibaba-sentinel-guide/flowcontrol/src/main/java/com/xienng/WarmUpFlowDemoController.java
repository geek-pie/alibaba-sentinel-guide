package com.xienng;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class WarmUpFlowDemoController {


    @Autowired
    private DownloadService downloadService;

    @GetMapping("/test")
    public String test1(HttpServletRequest request) throws Exception {
        System.err.println("ip:" + request.getRemoteAddr() + "线程：" + Thread.currentThread().getName());
        downloadService.download();
        return "OK";
    }





}
