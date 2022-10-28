package com.svj.controller;

import com.svj.bo.ProjectEngineerRepsonseBO;
import com.svj.entity.Engineer;
import com.svj.entity.Project;
import com.svj.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectManagementController {
    private ProjectManagementService projectManagementService;

    @Autowired
    public ProjectManagementController(ProjectManagementService projectManagementService){
        this.projectManagementService= projectManagementService;
    }

    @PostMapping("/projects")
    public Project saveProject(@RequestBody Project project){
        Project savedProject = projectManagementService.saveProject(project);
        return savedProject;
    }

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectManagementService.getProjects();
    }

    @GetMapping("/engineers")
    public List<Engineer> getEngineers(){
        return projectManagementService.getEngineers();
    }

    @DeleteMapping("/projects/{projectId}")
    public String deleteProject(@PathVariable int projectId){
        return projectManagementService.deleteProject(projectId);
    }

    @GetMapping("/join/sql")
    public String[] getProjectSpecificInfoSQL(){
        return projectManagementService.getProjectSpecificInfoSQL();
    }

    @GetMapping("/join/jpql")
    public List<ProjectEngineerRepsonseBO> getProjectSpecificInfoJPSQL(){
        return projectManagementService.getProjectSpecificInfoJPQL();
    }
}
