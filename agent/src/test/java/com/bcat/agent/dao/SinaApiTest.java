package com.bcat.agent.dao;

import com.bcat.agent.AgentApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

public class SinaApiTest extends AgentApplicationTest {

    @Autowired
    private SinaApi sinaApi;

    @Test
    public void getDataTest(){
        sinaApi.getData(Collections.singletonList("sh601006"));
    }
}
