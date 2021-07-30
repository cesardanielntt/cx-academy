package com.nttdata.spring.cxacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@EnableJpaRepositories("com.nttdata.spring.cxacademy.dao")
@SpringBootApplication(scanBasePackages = "com.nttdata.spring.cxacademy.*")
@EntityScan("com.nttdata.spring.cxacademy.model")
public class CxacademyApplication {

    public static void main(String[] args) {

        SpringApplication.run(CxacademyApplication.class, args);
    }

}
