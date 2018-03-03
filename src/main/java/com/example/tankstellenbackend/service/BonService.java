package com.example.tankstellenbackend.service;


import com.example.tankstellenbackend.model.Bon;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface BonService {
    public Bon add(Bon bon);
    public Bon deleteById(UUID id) throws NotFoundException;
    public List<Bon> findAll();
    public Bon findById(UUID id) throws NotFoundException;
    public Bon update(Bon bon) throws NotFoundException;
}
