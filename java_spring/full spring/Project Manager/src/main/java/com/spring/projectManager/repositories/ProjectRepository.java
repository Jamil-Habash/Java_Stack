package com.spring.projectManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.spring.projectManager.models.*;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findById(Long id);
    List<Project> findAll();
}
