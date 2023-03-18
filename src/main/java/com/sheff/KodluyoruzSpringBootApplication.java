package com.sheff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
    org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
//@SpringBootApplication
@EnableJdbcAuditing(auditorAwareRef = "auditorAware")
public class KodluyoruzSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodluyoruzSpringBootApplication.class, args);
    }

}
