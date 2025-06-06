package com.rafaeldsal.ws.minhaprata.configuration.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JavaMailSenderConfig {

  @Bean
  public JavaMailSender javaMailSender() {
    return new JavaMailSenderImpl();
  }
}
