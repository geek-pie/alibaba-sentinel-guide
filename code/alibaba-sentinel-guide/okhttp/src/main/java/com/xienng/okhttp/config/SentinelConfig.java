package com.xienng.okhttp.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class SentinelConfig {
//
//
//    @PostConstruct
//    private void init() {
//        initDegradeRule();
//    }
//
//
//    private void initDegradeRule() {
//        List<DegradeRule> rules = new ArrayList<>();
//        DegradeRule rule = new DegradeRule();
//        rule.setResource("okhttp:GET:http://localhost:8080/platform/do");
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT)
//                .setTimeWindow(60)
//                .setCount(1)
//                .setMinRequestAmount(1)
//                .setStatIntervalMs(10 * 1000);
//        rules.add(rule);
//        DegradeRuleManager.loadRules(rules);
//    }

}
