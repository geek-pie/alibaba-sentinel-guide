package com.xienng;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class SlowService {

    private static Logger logger = LoggerFactory.getLogger(SlowService.class);

    private static AtomicInteger pass = new AtomicInteger();
    private static AtomicInteger block = new AtomicInteger();
    private static AtomicInteger total = new AtomicInteger();


//    public String slow() throws BlockException {
//
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return "OK";
//    }


    public String slow() {

        Entry entry = null;
        try {
            entry = SphU.entry(SentinelConfig.RESOURCE_KEY);
            Thread.sleep(3000);
            logger.info("passed!,pass  count={}", pass.incrementAndGet());
        } catch (BlockException ex) {
            logger.error("blocked!,block  count={}", block.incrementAndGet());
            return "block";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            logger.info("total  count={}", total.incrementAndGet());
            if (entry != null) {
                entry.exit();
            }
        }
        return "OK";
    }

}

