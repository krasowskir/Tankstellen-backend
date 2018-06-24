package com.example.tankstellenbackend.controller;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.service.BonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/bons/bon/{bonId}", method = RequestMethod.POST)
    public ResponseEntity deleteById(@PathVariable String bonId){
        try {
            bonService.deleteById(UUID.fromString(bonId));
        } catch (ChangeSetPersister.NotFoundException ne){
            System.out.println("NotFoundException ");
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
