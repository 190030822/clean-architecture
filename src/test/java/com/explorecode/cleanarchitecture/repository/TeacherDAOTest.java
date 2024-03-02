package com.explorecode.cleanarchitecture.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.explorecode.cleanarchitecture.entity.Course;
import com.explorecode.cleanarchitecture.entity.Teacher;

import jakarta.transaction.Transactional;

@SpringBootTest
public class TeacherDAOTest {

    @Autowired
    private TeacherDAO teacherDao;

    @Autowired
    private CourseDAO courseDao;

    @Test
    public void saveTeacher() {
        Teacher teacher = new Teacher(1, "gbdg", null);
        teacherDao.save(teacher);
    }

    @Test
    public void updateCoursesToTeacher() {
        Optional<Course> course1 = courseDao.findById(1L);
        Optional<Course> course2 = courseDao.findById(2L);
        List<Course> courses = new ArrayList<Course>(List.of(course1.get(), course2.get()));
        Teacher teacher = teacherDao.findById(1L).get();
        courses.forEach((course) -> course.setTeacher(teacher));
        teacher.setCourses(courses);
        teacherDao.updateTeacherCourses(1, courses);
    }

    @Transactional
    @Test
    public void fetchTeacher() {
        Optional<Teacher> teacher = teacherDao.findById(1L);
        System.out.println(teacher.isPresent());
    }
}
