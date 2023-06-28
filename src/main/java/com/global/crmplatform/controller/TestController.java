package com.global.crmplatform.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    String testWelcome() {

        return "Hi Welcome";
    }

}
