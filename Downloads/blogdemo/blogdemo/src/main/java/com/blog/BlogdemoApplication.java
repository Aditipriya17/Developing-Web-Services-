package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.blog.entities")
public class BlogdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogdemoApplication.class, args);
    }

}
