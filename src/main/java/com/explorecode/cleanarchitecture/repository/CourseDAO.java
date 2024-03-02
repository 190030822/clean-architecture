package com.explorecode.cleanarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.explorecode.cleanarchitecture.entity.Course;
import com.explorecode.cleanarchitecture.entity.CourseMaterial;

import jakarta.transaction.Transactional;

public interface CourseDAO extends JpaRepository<Course, Long> {

    @Modifying
    @Transactional
    @Query("Update Course c set c.courseMaterial = ?1 where c.courseId = ?2")
    public int updateCourseMaterialByCourseId(CourseMaterial courseMaterial, long course_id);
    
}
