package com.buyerseller.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buyerseller.persistence.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // no body required
}
