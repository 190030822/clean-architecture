package com.explorecode.cleanarchitecture.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email_address", 
            name = "emailid_unique"
        ),
        @UniqueConstraint(columnNames = {"firstName", "lastName"},
        name = "unique_fullname"
        )
    }
)


public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    
    private String firstName;
    private String lastName;
    private String specalization;

    @Column(name = "email_address", nullable = false)
    @Email()
    private String emailId;

    @Embedded
    private Guardian guardian;

}
