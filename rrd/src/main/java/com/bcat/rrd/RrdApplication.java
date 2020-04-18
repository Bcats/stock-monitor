package com.bcat.rrd;

import com.bcat.agent.dao.SinaApi;
import com.bcat.agent.model.StockData;
import com.bcat.judge.model.AlertItem;
import com.bcat.judge.utils.AlertExpressionResolver;
import com.bcat.alarm.utils.EmailUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class RrdApplication {
    public static void main(String[] args) {
        SpringApplication.run(RrdApplication.class, args);

        Map<String, StockData> stockDataMap = new SinaApi().getDataByStockCodeList(Arrays.asList("sz002307","sh600928"));
        StockData stockData = stockDataMap.get("sz002307");

        AlertItem alertItem = new AlertItem();
        alertItem.setStockCode("sz002307");
        alertItem.setStockName(stockData.getStockName());
        alertItem.setAttrKey("todayOpenPrice");
        alertItem.setAttrName("今开");

        Map<String, Object> stockDataItemMap = stockData.getDataForMap();
        String AlarmAttrValue = String.valueOf(stockDataItemMap.get(alertItem.getAttrKey()));

        boolean isAlert = new AlertExpressionResolver().isTriggerAlarm("x gt 6.0", AlarmAttrValue);
        String emailTitle = " [" + alertItem.getStockName() + "]" + alertItem.getAttrName() ;

        if (isAlert){
            EmailUtils emailUtils = new EmailUtils();
            emailUtils.setSender("1905985427@qq.com");
            emailUtils.setReceiver("205672513@qq.com");
            emailUtils.setHost("smtp.qq.com");
            emailUtils.setMailUser("1905985427@qq.com");
            emailUtils.setMailPwd("hfjkkoptanfmgfej");
            emailUtils.setTitle(emailTitle);
            emailUtils.setContent("测试内容");

            emailUtils.send();
        }

    }
}
