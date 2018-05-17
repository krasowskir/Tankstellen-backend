package com.example.tankstellenbackend.controller;

import com.example.tankstellenbackend.model.Bon;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BonController {

    Bon bonDto = new Bon();

    @RequestMapping(value = "/bons", method = RequestMethod.GET)
    public String getBonEditPage(Bon bon){
        return "bonEditPage";
    }

    @RequestMapping(value = "/bonis", method = RequestMethod.POST)
    public HttpEntity<String> saveBon(Bon bon){

        return new HttpEntity<>(bon.toString());
    }
}
