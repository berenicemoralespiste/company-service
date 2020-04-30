package com.secondmicroservice.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    UserInterface clientInterface;

    @Value("${secondmicroservice.company}")
    String companyId;


    @GetMapping("/company/users/{username}")
    public Boolean checkUserOnCompany(@PathVariable String username) {

        Boolean response = false;
        Object user = clientInterface.validateClient(username,companyId);
        if(user != null){
            response = true;
        }
        return response;

    }

}
