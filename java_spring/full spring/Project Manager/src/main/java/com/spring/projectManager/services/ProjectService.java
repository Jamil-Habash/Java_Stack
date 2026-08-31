package com.spring.projectManager.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.spring.projectManager.models.Project;
import com.spring.projectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> allProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project p){
        return projectRepository.save(p);
    }

    public Project findProject(long id){
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()){
            return optionalProject.get();
        } else{
            return null;
        }
    }

    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }
}
