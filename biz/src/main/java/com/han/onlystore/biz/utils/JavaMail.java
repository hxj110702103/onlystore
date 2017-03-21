package com.han.onlystore.biz.utils;

import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.util.Properties;

/**
 * Created by Amy on 2017/3/20.
 */
@Component
public class JavaMail {

    private static final String HOST = "smtp.163.com";

    public void sendMail(String to, String code) throws MessagingException {
        //1.创建连接对象，连接邮箱服务器
        Properties props= new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", HOST);
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("m18233138990@163.com", "hxj123456");
            }
        });

        //2.创建邮件对象
        MimeMessage message =   new MimeMessage(session);
        Address fromAddress = new InternetAddress("m18233138990@163.com");
        message.setFrom(fromAddress);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("m13817556575@163.com"));
        message.setSubject("账号激活邮件");
        message.setContent("账号激活邮件，点击以下连接激活", "text/html;charset=utf-8");

        //3.发送邮件
        Transport.send(message);
    }

}
