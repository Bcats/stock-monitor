package com.bcat.agent.dao;

import com.bcat.agent.AgentApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

public class SinaApiTest extends AgentApplicationTest {

    @Autowired
    private SinaApi sinaApi;

    @Test
    public void getDataTest(){
        sinaApi.getData(Arrays.asList("sz002307","sh600928"));
    }

    @Test
    public void test1(){
        Assert.assertTrue("var hq_str_sz001002".matches("^var\\d*$"));
    }
}
