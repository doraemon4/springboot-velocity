package com.stephen.learning.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Map;

/**
 * @Auther: jack
 * @Date: 2018/11/12 16:03
 * @Description:  邮件发送业务
 */
@Service
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private VelocityEngine velocityEngine;

    /**
     * 发送邮件
     * @param model  信息
     * @param subject 邮件主题
     * @param to      接收者
     * @param templete  邮件模版
     */
    public void sendMail(Map<String, Object> model,String subject,String to,String templete){
        MimeMessagePreparator mimeMessagePreparator=mimeMessage->{
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "GBK");
            //设置接收方的email地址
            message.setTo(to);
            //设置邮件主题
            message.setSubject(subject);
            //设置发送方地址
            message.setFrom(sender);
            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, templete, "UTF-8", model);
            message.setText(text, true);
        };
        int times = 3;
        for (int i = 0; i < times; i++) {
            try {
                //发送邮件
                this.mailSender.send(mimeMessagePreparator);
                break;
            } catch (Exception e) {
                log.error("sending occur error");
                continue;
            }
        }
    }
}
