package com.it.articleservice.controllers;

import com.it.articleservice.service.UserRemoteClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "新增用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://CLIENT-SERVICE/user/hello", String.class);
    }

    @Autowired
    private UserRemoteClient userRemoteClient;
    @GetMapping("/callHello")
    public String callHello2() {
        //return restTemplate.getForObject("http://localhost:8083/house/hello",String.class);
        //String result = restTemplate.getForObject("http://eureka-client-user-service/user/hello",String.class);
        String result = userRemoteClient.hello();
        System.out.println("调用结果：" + result);
        return result;
    }
}
