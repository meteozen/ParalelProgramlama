package com.example.javatutorials;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.TimeZone;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")


@EntityScan(basePackages = "com.example.data.entity") //Entity bulamadığı zaman
@EnableJpaRepositories(basePackages ="com.example" ) //Repository bulamadığı zaman
//@EntityScan(basePackages = "com.hamitmizrak.data.entity") //Entity bulamadığı zaman
//@EnableJpaRepositories(basePackages ="com.hamitmizrak.data.repository" ) //Repository bulamadığı zaman

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        //org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

public class JavaTutorialsApplication {
    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    }

    public static void main(String[] args) {

        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(JavaTutorialsApplication.class, args);
    }
}
