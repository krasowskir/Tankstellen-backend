package com.example.tankstellenbackend.persistence;


import com.example.tankstellenbackend.model.Tankstelle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TankstellenRepository extends JpaRepository<Tankstelle, UUID>{
}
