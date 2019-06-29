package com.example.tankstellenbackend.service;

import com.example.tankstellenbackend.model.Tankstelle;
import com.example.tankstellenbackend.persistence.TankstellenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MyTankstellenService implements TankstellenService {

    private TankstellenRepository tankstellenRepository;

    @Autowired
    public MyTankstellenService(TankstellenRepository tankstellenRepository) {
        this.tankstellenRepository = tankstellenRepository;
    }

    @Override
    public void createTankstelle(Tankstelle tankstelle) {
        tankstellenRepository.save(tankstelle);
    }

    @Override
    public void deleteTankstelle(String id) {
        tankstellenRepository.delete(UUID.fromString(id));
    }

    @Override
    public void updateTankstelle(Tankstelle updateTankstelle) {
        tankstellenRepository.save(updateTankstelle);
    }

    @Override
    public Tankstelle getTankStelleById(String id) {
        return tankstellenRepository.findOne(UUID.fromString(id));
    }

    @Override
    public List<Tankstelle> getAllTankstellen() {
        return tankstellenRepository.findAll();
    }
}
