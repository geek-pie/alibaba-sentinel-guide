package com.xienng.helloworld;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class QueryService {

    private static final String KEY = "queryService";

    private AtomicInteger errorCount = new AtomicInteger();

    @SentinelResource(value = KEY, blockHandler = "blockHandlerMethod",
            fallback = "fallbackMethod")
    public String query(String param) {
        if (param.endsWith("ERROR")) {
            System.err.println("依旧在执行query方法，error:" + errorCount.incrementAndGet());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("执行query方法出现异常");
        }
        return "begin query method, param= " + param;
    }

    public String blockHandlerMethod(String param, BlockException e) {
        System.err.println("blockHandlerMethod 接收到异常");
        return "blockHandlerMethod for Query : " + param;
    }

    public String fallbackMethod(String param, Throwable e) {
        System.err.println("fallbackMethodMethod 接收到异常");
        return "fallbackMethod for Query : " + param;
    }


}
