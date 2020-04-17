package com.bcat.rrd;

import com.bcat.agent.dao.SinaApi;
import com.bcat.agent.model.StockData;
import com.bcat.judge.model.CompareItem;
import com.bcat.judge.utils.CompareItemResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
public class RrdApplication {
    public static void main(String[] args) {
        SpringApplication.run(RrdApplication.class, args);

        Map<String, StockData> stockDataMap = new SinaApi().getDataByStockCodeList(Arrays.asList("sz002307","sh600928"));
        StockData stockData = stockDataMap.get("sz002307");

        CompareItem compareItem = new CompareItem();
        compareItem.setCompareKey("todayOpenPrice");

        Map<String, Object> stockDataItemMap = stockData.getDataForMap();
           String compareValue = (String) stockDataItemMap.get(compareItem.getCompareKey());

        boolean isAlarm = new CompareItemResolver().isTriggerAlarm("x gt 8.0", compareValue);
        System.out.println("");

    }
}
