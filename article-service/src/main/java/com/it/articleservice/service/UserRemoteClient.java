package com.it.articleservice.service;

import com.it.articleservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "client-service",configuration = FeignConfiguration. class)
public interface UserRemoteClient {
    @GetMapping("/user/hello")
    String hello();
}
