package com.svj.repository;

import com.svj.entity.Engineer;
import com.svj.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer, Integer> {
}
