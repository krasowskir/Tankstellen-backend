package com.example.tankstellenbackend.controller;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.service.BonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/api")
public class BonRestController {

    private static final Logger log = LoggerFactory.getLogger(BonController.class);

    private BonService bonService;

    @Autowired
    public BonRestController(BonService bonService) {
        this.bonService = bonService;
    }

    @ApiOperation(value = "liefert alle Bons aus", response = List.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successfully delivering all bons")
    })
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
