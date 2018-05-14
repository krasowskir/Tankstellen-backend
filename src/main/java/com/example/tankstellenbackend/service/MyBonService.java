package com.example.tankstellenbackend.service;


import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.persistence.BonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class MyBonService implements BonService{

    private BonRepository bonRepository;

    @Autowired
    public MyBonService(BonRepository bonRepository){
        this.bonRepository = bonRepository;
    }

    @Transactional
    @Override
    public Bon add(Bon bon) {
        return bonRepository.save(bon);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    @Override
    public Bon deleteById(UUID id) throws NotFoundException {
        Bon deleted = findById(id);
        bonRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Bon> findAll() {
        return bonRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Bon findById(UUID id) throws NotFoundException {
        Bon bon = bonRepository.findOne(id.toString());
        if (bon == null) throw new NotFoundException();
        return bon;
    }

    @Transactional(readOnly = true)
    public Bon findById(String id) throws NotFoundException {
        Bon bon = bonRepository.findOne(id);
        if (bon == null) throw new NotFoundException();
        return bon;
    }

    @Transactional(rollbackFor = NotFoundException.class)
    @Override
    public Bon update(Bon bon) throws NotFoundException {
        Bon found = findById(bon.getId().toString());
        if (found == null) throw new NotFoundException();
        found.setBenzinPreis(bon.getBenzinPreis());
        found.setDatum(bon.getDatum());
        found.setEndPreis(bon.getEndPreis());
        found.setTankstellenName(bon.getTankstellenName());
        found.setTankVolumen(bon.getTankVolumen());
        return found;
    }
}
