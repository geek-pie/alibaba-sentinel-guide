package com.xienng.okhttp.controller;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;


@RestController
@RequestMapping("gateway")
public class GatewayController {


    @Autowired
    private OkHttpClient okHttpClient;

    @GetMapping("/query")
    public void query() throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://xmg-upflag.oss-cn-hangzhou.aliyuncs.com/20231114/MZ20231114015046278809517460654/1001.mp4")
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();


            BufferedInputStream inputStream =
                    new BufferedInputStream(Objects.requireNonNull(response.body()).byteStream(), 8192);

            FileOutputStream fos = new FileOutputStream("text.mp4");
            byte[] buffer = new byte[4096];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
