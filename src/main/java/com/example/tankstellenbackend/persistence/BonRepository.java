package com.example.tankstellenbackend.persistence;


import com.example.tankstellenbackend.model.Bon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BonRepository extends JpaRepository<Bon, String>{

}
