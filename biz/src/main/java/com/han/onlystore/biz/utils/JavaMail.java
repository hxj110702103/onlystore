package com.han.onlystore.biz.utils;

import com.han.onlystore.biz.config.EmailProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmailProperties emailProperties;

    public void sendMail(String to, String code) throws MessagingException {
        //1.创建连接对象，连接邮箱服务器
        Properties props= new Properties();
        props.setProperty("mail.transport.protocol", emailProperties.getMailTransportProtocol());
        props.put("mail.smtp.host", emailProperties.getMailSmtpHost());
        props.setProperty("mail.smtp.auth", emailProperties.getMailSmtpAuth());

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperties.getUsername(), emailProperties.getPassword());
            }
        });

        //2.创建邮件对象
        MimeMessage message =   new MimeMessage(session);
        Address fromAddress = new InternetAddress(emailProperties.getUsername());
        message.setFrom(fromAddress);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("m13817556575@163.com")); //这里将接收邮件人，设为了固定值
        message.setSubject("账号激活邮件");
        message.setContent("账号激活邮件，点击以下连接激活", "text/html;charset=utf-8");

        //3.发送邮件
        Transport.send(message);
    }
}
