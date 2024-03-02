package com.explorecode.cleanarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.explorecode.cleanarchitecture.entity.CourseMaterial;

public interface CourseMaterialDAO extends JpaRepository<CourseMaterial, Long>{
    
}
