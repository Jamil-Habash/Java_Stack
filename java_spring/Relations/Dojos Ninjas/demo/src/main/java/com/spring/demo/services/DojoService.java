package com.spring.demo.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.spring.demo.models.Dojo;
import com.spring.demo.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository){
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo d){
        return dojoRepository.save(d);
    }

    public Dojo findDojo(long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()){
            return optionalDojo.get();
        } else{
            return null;
        }
    }

    public void deleteDojo(Long id){
        dojoRepository.deleteById(id);
    }
}
