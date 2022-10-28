package com.svj.repository;

import com.svj.bo.ProjectEngineerRepsonseBO;
import com.svj.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT p.name as proj_name, e.name as emp_name, e.email FROM Project p JOIN Engineer e\n" +
            " ON p.project_id= e.project_engineer_fk", nativeQuery = true)
    public String[] getProjectSpecificInfo();

    @Query(value = "SELECT new com.svj.bo.ProjectEngineerRepsonseBO(p.name, p.projectCode, e.name, e.email) FROM Project p JOIN p.engineers e")
    public List<ProjectEngineerRepsonseBO> getProjectSpecificInfoWithJPQL();
}