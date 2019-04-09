package com.zwwhnly.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableScheduling
public class SpringbootdemoApplication {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/")
    public String index() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }

    @RequestMapping("/indexV2")
    public String indexV2() {
        return "author name is:" + authorSettings.getName() + " and author age is:" + authorSettings.getAge();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }
}

