package com.example.tankstellenbackend.controller;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.service.BonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BonRestController {

    private static final Logger log = LoggerFactory.getLogger(BonController.class);

    private BonService bonService;

    @Autowired
    public BonRestController(BonService bonService) {
        this.bonService = bonService;
    }

    @RequestMapping(value = "/allBons")
    public List<Bon> getAllBons(){
        log.info("fetching all bons");
        List<Bon> bons = bonService.findAll();
        for (Bon elem : bons){
            log.info("bons {}", elem.getEndPreis());
        }

        return bons;
    }
}
