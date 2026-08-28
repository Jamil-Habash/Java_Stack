package com.spring.demo.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.spring.demo.models.Dojo;
import com.spring.demo.models.Ninja;
import com.spring.demo.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjsRepository;

    public NinjaService(NinjaRepository ninjsRepository){
        this.ninjsRepository = ninjsRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjsRepository.findAll();
    }

    public Ninja createNinja(Ninja d){
        return ninjsRepository.save(d);
    }

    public Ninja findNinja(long id){
        Optional<Ninja> optionalNinja = ninjsRepository.findById(id);
        if(optionalNinja.isPresent()){
            return optionalNinja.get();
        } else{
            return null;
        }
    }

    public void deleteNinja(Long id){
        ninjsRepository.deleteById(id);
    }
}
