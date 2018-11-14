package com.tiancy.consumer.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tiancy.consumer.consumer.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
@GetMapping("/movie/user/{id}")
@HystrixCommand(fallbackMethod = "findByIdFallbank")
    public User findById(@PathVariable  Long id){
       return  restTemplate.getForObject("http://application-provider/simple/"+id,User.class);
    }


    public  User findByIdFallbank(Long id){
        User user=new User();
        user.setId(0L);
        return user;
    }
}
