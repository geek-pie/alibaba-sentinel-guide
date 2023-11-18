package com.xienng.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年10月31日 16:30
 */

@RestController
public class HelloController {

    @Autowired
    private QueryService queryService;


    @GetMapping(value = "query")
    public String query() {
        String[] params = {"OK", "ERROR"};
        int random = new Random().nextInt(2);
        return queryService.query(params[random]);
    }


//    @GetMapping(value = "queryRemote")
//    public String queryRemote() {
//
//
//
//
//    }

    @GetMapping("/test")
    public String test1(HttpServletRequest request) throws Exception {
        System.err.println("ip:"+request.getRemoteAddr() +"线程："+Thread.currentThread().getName());
        Thread.sleep(500);
        return "OK";
    }
}
