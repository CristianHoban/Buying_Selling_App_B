package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blabla")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
