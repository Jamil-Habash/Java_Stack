package com.spring.projectManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.spring.projectManager.models.*;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findAll();
    
}
