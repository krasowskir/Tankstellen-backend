package com.example.Tankstellenbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("all is okay", HttpStatus.OK);
    }
}
