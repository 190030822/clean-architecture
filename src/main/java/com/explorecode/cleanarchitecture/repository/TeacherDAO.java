package com.explorecode.cleanarchitecture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.explorecode.cleanarchitecture.entity.Course;
import com.explorecode.cleanarchitecture.entity.Teacher;

import jakarta.transaction.Transactional;

public interface TeacherDAO extends JpaRepository<Teacher, Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Teacher t SET t.courses = :courses WHERE t.teacherId = :teacherId")
    public int updateTeacherCourses(@Param("teacherId") long teacherId, @Param("courses") List<Course> courses);

    
}
