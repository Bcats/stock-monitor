package com.bcat.alarm.utils;

import org.junit.jupiter.api.Test;

class EmailUtilsTest {
    @Test
    public void setEmail(){

        EmailUtils emailUtils = new EmailUtils();

        emailUtils.setSender("1905985427@qq.com");
        emailUtils.setReceiver("205672513@qq.com");
        emailUtils.setHost("smtp.qq.com");
        emailUtils.setMailUser("1905985427@qq.com");
        emailUtils.setMailPwd("hfjkkoptanfmgfej");
        emailUtils.setTitle("测试");
        emailUtils.setContent("测试内容");

        if (emailUtils.send()){
            System.out.println("success");
        }
    }


}