package com.xienng;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class DownloadUtils {

    private static Logger logger = LoggerFactory.getLogger(DownloadUtils.class);

    public static void download(OkHttpClient okHttpClient, String url) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            //这种方式会将返回的所有字节全部加载到内置中间，生产环境不建议这么用
            byte[] getData = response.body().bytes();
            logger.info("文件下载完成，字节数：{}", getData.length);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
