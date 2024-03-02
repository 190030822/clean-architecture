package com.explorecode.cleanarchitecture.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long courseId;
    private String name;
    private double credits;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(
        referencedColumnName = "courseMaterialId",
        name = "course_material_id"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "teacherId", name = "teacher_id")
    private Teacher teacher;
}