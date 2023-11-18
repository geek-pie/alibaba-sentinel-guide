package com.xienng;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Configuration
public class SentinelConfig {
    public static final String RESOURCE_KEY = "CONTROL_BEHAVIOR_WARM_UP";

    @PostConstruct
    private void init() {
        initFlowRule();
    }


    private static void initFlowRule() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule1 = new FlowRule();
        rule1.setResource(RESOURCE_KEY);
        rule1.setCount(20);
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP);
        rule1.setWarmUpPeriodSec(10);
        rules.add(rule1);
        FlowRuleManager.loadRules(rules);
    }

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .callTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }
}


