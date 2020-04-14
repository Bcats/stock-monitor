package com.bcat.alarm.model;

import org.junit.jupiter.api.Test;

class EmailTest {
    @Test
    public void setEmail(){

        Email email = new Email();

        email.setSender("1905985427@qq.com");
        email.setReceiver("205672513@qq.com");
        email.setHost("smtp.qq.com");
        email.setMailUser("1905985427@qq.com");
        email.setMailPwd("hfjkkoptanfmgfej");
        email.setTitle("测试");
        email.setContent("测试内容");

        if (email.send()){
            System.out.println("success");
        }
    }


}