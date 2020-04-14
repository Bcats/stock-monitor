package com.bcat.alarm.model;

import lombok.Setter;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Setter
public class Email {
    // 收件人
    private String receiver;
    // 发件人
    private String sender;
    // smtp服务器地址
    private String host;
    // 发件邮箱账号
    private String mailUser;
    // 发件邮箱授权码
    private String mailPwd;
    // 邮件标题
    private String title;
    // 邮件内容
    private String content;

    public boolean send(){

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.auth", "true");

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailUser, mailPwd);
            }
        });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiver));
            message.setSubject(title);
            message.setText(content);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }

}
