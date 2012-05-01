package com.umitunal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.umitunal.config.ApplicationConfig;

public class StandTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();
    }
}
