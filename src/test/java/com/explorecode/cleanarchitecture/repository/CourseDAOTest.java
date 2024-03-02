package com.explorecode.cleanarchitecture.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.explorecode.cleanarchitecture.entity.Course;
import com.explorecode.cleanarchitecture.entity.CourseMaterial;

@SpringBootTest
public class CourseDAOTest {

    @Autowired
    private CourseDAO courseDAO;

    @Test 
    public void createCourse() {

        Course course = new Course(1111, "Software Engineering", 10, new CourseMaterial(11, "www.google.com"), null);
        courseDAO.save(course);
    }

    @Test
    public void updateCourseMaterialByCourse() {
        // CourseMaterial courseMaterial = new CourseMaterial(1, "www.geeksforgeeks.com");
        // courseDAO.updateCourseMaterialByCourseId(courseMaterial, 1);

    }

}
