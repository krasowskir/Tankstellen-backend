package com.example.tankstellenbackend;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.model.Tankstelle;
import com.example.tankstellenbackend.service.BonService;
import com.example.tankstellenbackend.service.MyTankstellenService;
import com.example.tankstellenbackend.service.TankstellenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component(value = "Start")
public class Start {

    private Bon exampleBon;

    private BonService bonService;

    private TankstellenService tankstellenService;

    @Autowired
    @Qualifier("aral")
    private Tankstelle aral;

    @Autowired
    @Qualifier("shell")
    private Tankstelle shell;

    @Autowired
    @Qualifier("esso")
    private Tankstelle esso;

    @Autowired
    public Start(BonService bonService, Bon exampleBon, TankstellenService tankstellenService){
        this.bonService = bonService;
        this.exampleBon = exampleBon;
        this.tankstellenService = tankstellenService;
    }

    //comment this in or out
    //@PostConstruct
    public void insertExampleBonIntoDb(){
        bonService.add(exampleBon);
        System.out.println("SUCCESS");
    }

    //comment this in or out
    //@PostConstruct
    public void insertExampleTankstellenIntoDb(){

        tankstellenService.createTankstelle(aral);
        tankstellenService.createTankstelle(shell);
        tankstellenService.createTankstelle(esso);
    }
}
