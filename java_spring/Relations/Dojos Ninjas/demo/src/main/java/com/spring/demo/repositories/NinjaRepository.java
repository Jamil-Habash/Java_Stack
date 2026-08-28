package com.spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.spring.demo.models.*;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

    List<Ninja> findAll();
    
}
