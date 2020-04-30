package com.secondmicroservice.company.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service", url = "http://localhost:8081")
public interface UserInterface {

        @GetMapping("/users/{username}/company/{company}")
        public Object validateClient(@PathVariable String username,@PathVariable("company") String company);
}

