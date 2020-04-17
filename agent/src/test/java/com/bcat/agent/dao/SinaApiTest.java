package com.bcat.agent.dao;

import com.bcat.agent.AgentApplicationTest;
import com.bcat.agent.model.StockData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class SinaApiTest extends AgentApplicationTest {

    @Autowired
    private SinaApi sinaApi;

    @Test
    public void getDataTest(){
        Map map = sinaApi.getDataByStockCodeList(Arrays.asList("sz002307","sh600928"));
        StockData stockData = (StockData) map.get("sz002307");
        System.out.println(stockData.toString());
    }

    @Test
    public void test1(){
        Assert.assertTrue("var hq_str_sz001002".matches("^var\\d*$"));
    }
}
