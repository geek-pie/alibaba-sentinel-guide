package com.xienng;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FlowGradeThreadDemoController {


    @Autowired
    private SlowService slowService;

    @Autowired
    private NormalService normalService;

    @GetMapping("/slow")
    public String slow(HttpServletRequest request) throws Exception {
        System.err.println("/slow ip:" + request.getRemoteAddr() + "线程：" + Thread.currentThread().getName());
        slowService.slow();
        return "OK";
    }

    @GetMapping("/normal")
    public String normal(HttpServletRequest request) throws Exception {
        System.err.println("/normal ip:" + request.getRemoteAddr() + "线程：" + Thread.currentThread().getName());
        normalService.normal();
        return "OK";
    }


}
