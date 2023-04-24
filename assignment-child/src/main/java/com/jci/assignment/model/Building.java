package com.jci.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

@Entity
@Table(appliesTo = "")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Id
    @Column
    private int buildingId;
    @Column
    private String buildingName;
    @Column
    private String city;
    @Column
    private String pinCode;
}
