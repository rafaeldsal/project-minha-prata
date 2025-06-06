package com.rafaeldsal.ws.minhaprata.integration.impl;

import com.rafaeldsal.ws.minhaprata.integration.MailIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailIntegrationImpl implements MailIntegration {

  @Value("${spring.mail.from}")
  private String sender;

  private final JavaMailSender javaMailSender;

  @Override
  public void send(String mailTo, String message, String subject) {
    SimpleMailMessage smm = new SimpleMailMessage();
    smm.setTo(mailTo);
    smm.setSubject(subject);
    smm.setText(message);
    smm.setFrom(sender);
    javaMailSender.send(smm);
  }
}
