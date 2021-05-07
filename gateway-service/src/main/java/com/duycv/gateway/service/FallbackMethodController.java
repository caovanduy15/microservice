package com.duycv.gateway.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/employeeServiceFallback")
    public String employeeServiceFallbackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }
    
    @GetMapping("/organizationServiceFallback")
    public String organizationServiceFallbackMethod() {
        return "Oganization Service is taking longer than Expected." +
                " Please try again later";
    }
}
