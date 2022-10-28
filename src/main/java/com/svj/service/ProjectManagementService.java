package com.svj.service;

import com.svj.bo.ProjectEngineerRepsonseBO;
import com.svj.entity.Engineer;
import com.svj.entity.Project;
import com.svj.repository.EngineerRepository;
import com.svj.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagementService {
    private ProjectRepository projectRepository;
    private EngineerRepository engineerRepository;

    @Autowired
    public ProjectManagementService(ProjectRepository projectRepository, EngineerRepository engineerRepository){
        this.engineerRepository= engineerRepository;
        this.projectRepository= projectRepository;
    }

    public Project saveProject(Project project){
        Project savedProject = projectRepository.save(project);
        return savedProject;
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public List<Engineer> getEngineers(){
        return engineerRepository.findAll();
    }

    public String deleteProject(int projectId){
        projectRepository.deleteById(projectId);
        return "Project- ".concat(String.valueOf(projectId)).concat(" deleted!!!");
    }

    public String[] getProjectSpecificInfoSQL(){
        return projectRepository.getProjectSpecificInfo();
    }

    public List<ProjectEngineerRepsonseBO> getProjectSpecificInfoJPQL(){
        return projectRepository.getProjectSpecificInfoWithJPQL();
    }
}
