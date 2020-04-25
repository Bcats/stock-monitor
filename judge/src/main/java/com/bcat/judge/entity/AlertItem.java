package com.bcat.judge.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlertItem {

    // 股票代码
    private String stockCode;
    // 股票名称
    private String stockName;
    // 告警项比较参数名称
    private String attrName;
    // 告警项比较参数key
    private String attrKey;
    // 告警触发表达式
    private String expression;
    // 告警间隔时间
    private String intervalTime;

}
