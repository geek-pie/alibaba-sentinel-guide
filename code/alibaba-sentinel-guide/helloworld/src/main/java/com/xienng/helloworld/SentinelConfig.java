package com.xienng.helloworld;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年10月31日 16:14
 */
@Component
public class SentinelConfig {


    @PostConstruct
    private void init() {
        initDegradeRule();
    }


    //熔断降级规则
    private void initDegradeRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        //通过Key来区分当前配置属于哪个方法
        rule.setResource("queryService");
        // 10s内调用接口出现2次异常，进行熔断

        //熔断的规则为异常的数量
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT)
                .setTimeWindow(60)
                .setCount(1)
                .setMinRequestAmount(1)
                .setStatIntervalMs(60*1000);

        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }

}
