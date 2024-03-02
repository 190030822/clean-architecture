package com.explorecode.cleanarchitecture.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.explorecode.cleanarchitecture.entity.Guardian;
import com.explorecode.cleanarchitecture.entity.Student;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    // @Test
    // public void saveStudent() {

    //     Guardian guardian = new Guardian("yuvi", "1234567890", "father");

    //     Student s = new Student(11111, "rinku", "sing", "datascience", "rinku@gmail.com", guardian);

    //     // Guardian guardian = new Guardian("atcharao", "1234567890", "father");

    //     // Student s = new Student(11111, "karthik", "kohli", "datascience", "karthik@gmail.com", guardian);

    //     // Guardian guardian = new Guardian("kohli", "123456789", "father");

    //     // Student s = new Student(11111, "virat", "kohli", "datascience", "virat@gmail.com", guardian);

    //     studentDAO.save(s);
    // }

    @Test
    public void getStudentsByLastName() {
        List<Student> students =  studentDAO.findByLastName("kohli");
        students.forEach((student)-> System.out.println(student));
    }

    @Test
    public void getStudentByLastNameStartingWith() {
        List<Student> students = studentDAO.findByLastNameContaining("li");
        students.forEach((student) -> System.out.println(student));
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentDAO.getStudentByEmailAddress("virat@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateFirstNameBasedOnEmailId() {
        int value = studentDAO.updateFirstNameBasedOnEmailId("rinkuKKR", "rinku@gm.com");
        System.out.println(value);
    }

    @Test 
    public void deleteStudentBasedOnEmailId() {
        int value = studentDAO.deleteStudentBasedOnEmailId("rinku@gmail.com");
        System.out.println(value);
    }

}
