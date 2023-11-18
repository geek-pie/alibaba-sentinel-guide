package com.xienng.okhttp.config;


import com.alibaba.csp.sentinel.adapter.okhttp.SentinelOkHttpConfig;
import com.alibaba.csp.sentinel.adapter.okhttp.SentinelOkHttpInterceptor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class DefaultOkHttpConfig {


    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .callTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

}
