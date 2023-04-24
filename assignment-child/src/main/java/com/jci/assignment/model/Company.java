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
public class Company {
    @Id
    @Column
    private int companyId;
    @Column
    private String companyName;
    @Column
    private String city;
    @Column
    private String pinCode;
}
