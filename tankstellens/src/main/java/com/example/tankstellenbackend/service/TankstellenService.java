package com.example.tankstellenbackend.service;


import com.example.tankstellenbackend.model.Tankstelle;

import java.util.List;

public interface TankstellenService {

    void createTankstelle(Tankstelle tankstelle);
    void deleteTankstelle(String id);
    void updateTankstelle(Tankstelle updateTankstelle);
    Tankstelle getTankStelleById(String id);
    List<Tankstelle> getAllTankstellen();
}
