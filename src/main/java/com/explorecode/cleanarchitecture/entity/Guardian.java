package com.explorecode.cleanarchitecture.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(column = @Column(name = "guardian_name", nullable = false), name = "name"),
    @AttributeOverride(column = @Column(name ="guardian_mobile_no", nullable = false), name = "mobileNumber"),
    @AttributeOverride(column = @Column(name = "guardian_relation", nullable = false), name = "relation")
})
public class Guardian {

    private String name;
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobileNumber;
    private String relation;
}
