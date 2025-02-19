package com.example.githubrepositoriesapi;

import com.example.githubrepositoriesapi.domain.proxy.GithubApiClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@Log4j2
@SpringBootApplication
@EnableFeignClients
public class GithubRepositoriesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubRepositoriesApiApplication.class, args);
    }

}
