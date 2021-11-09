package com.example.provabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@EntityScan(basePackages = {
        "com.example.provabackend.model"
})
@EnableJpaRepositories(basePackages = {
        "com.example.provabackend.repository"
})


@SpringBootApplication
@RestController
public class ProvaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaBackendApplication.class, args);
    }

}
