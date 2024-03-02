package com.explorecode.cleanarchitecture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.explorecode.cleanarchitecture.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentDAO extends JpaRepository<Student, Long> {

    public List<Student> findByLastName(String lastName);

    public List<Student> findByLastNameContaining(String lastName);

    public List<Student> findByLastNameNotNull();

    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailAddress);

    @Modifying
    @Transactional
    @Query(
        value = "Update student s set s.first_name = ?1 where s.email_address = ?2",
        nativeQuery = true
    )
    public int updateFirstNameBasedOnEmailId(String firstName, String emailId);

    @Modifying
    @Transactional
    @Query(
        value = "Delete from Student s where s.email_address = ?1",
        nativeQuery = true
    )
    public int deleteStudentBasedOnEmailId(String emailId);


  
}
