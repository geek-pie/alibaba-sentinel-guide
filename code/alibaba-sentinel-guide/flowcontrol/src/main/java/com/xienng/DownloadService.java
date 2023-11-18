package com.xienng;


import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class DownloadService {

    private static Logger logger = LoggerFactory.getLogger(DownloadService.class);

    private static AtomicInteger pass = new AtomicInteger();
    private static AtomicInteger block = new AtomicInteger();
    private static AtomicInteger total = new AtomicInteger();

    @Autowired
    private OkHttpClient okHttpClient;


    public String download() throws BlockException {
        String url = "https://docs.oracle.com/javase/specs/jvms/se19/html/jvms-2.html";
        Entry entry = null;
        try {
            entry = SphU.entry(SentinelConfig.RESOURCE_KEY);

            // 处理被流控的逻辑
            DownloadUtils.download(okHttpClient, url);

            logger.info("passed!,pass  count={}", pass.incrementAndGet());

        } catch (BlockException ex) {
            logger.error("blocked!,block  count={}", block.incrementAndGet());
            throw ex;
        } finally {
            logger.info("total  count={}", total.incrementAndGet());
            if (entry != null) {
                entry.exit();
            }
        }
        return "OK";
    }


//    public String download() throws BlockException {
//        String url = "https://docs.oracle.com/javase/specs/jvms/se19/html/jvms-2.html";
//
//        // 处理被流控的逻辑
//        DownloadUtils.download(okHttpClient, url);
//
//        logger.info("passed!,pass  count={}", pass.incrementAndGet());
//
//        return "OK";
//    }

}

