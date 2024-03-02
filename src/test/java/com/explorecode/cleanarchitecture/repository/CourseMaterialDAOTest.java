package com.explorecode.cleanarchitecture.repository;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.explorecode.cleanarchitecture.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialDAOTest {

    @Autowired
    CourseMaterialDAO courseMaterialDAO;

    @Test 
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = new CourseMaterial(11, "www.geeksforgeeks.com");
        courseMaterialDAO.save(courseMaterial);
    }

    @Autowired
    private ModelMapper modelMapper;
}
