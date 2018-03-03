package com.example.tankstellenbackend;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.service.BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "Start")
public class Start {

    Bon exampleBon;

    BonService bonService;

    @Autowired
    public Start(BonService bonService, Bon exampleBon){
        this.bonService = bonService;
        this.exampleBon = exampleBon;
    }

    public void insertExampleBonIntoDb(){
        bonService.add(exampleBon);
        System.out.println("SUCCESS");
    }
}
