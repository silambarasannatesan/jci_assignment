package com.jci.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(appliesTo = "")
public class Employee {

    @Id
    @Column
    private int employeeId;
    @Column
    private String employeeName;
    @Column
    private String employeeDept;
    @Column
    private String role;
}
