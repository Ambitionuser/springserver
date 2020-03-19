package com.it.articleservice.controllers;

import com.it.articleservice.service.UserRemoteClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "add")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @GetMapping("/article/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://CLIENT-SERVICE/user/hello", String.class);
    }

    @Autowired
    private UserRemoteClient userRemoteClient;

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/callHello")
    public String callHello2() {
        //return restTemplate.getForObject("http://localhost:8083/house/hello",String.class);
        //String result = restTemplate.getForObject("http://eureka-client-user-service/user/hello",String.class);
        redisTemplate.opsForValue().set("ppp","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
//        redisTemplate.opsForHash().put("bbbsdafd","myValue","aa");
//        String result = userRemoteClient.hello();
//        System.out.println("调用结果：" + result);
        return redisTemplate.opsForValue().get("myKey").toString();
    }

}
