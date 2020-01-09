package com.it.articleservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://CLIENT-SERVICE/user/hello", String.class);
    }
}
