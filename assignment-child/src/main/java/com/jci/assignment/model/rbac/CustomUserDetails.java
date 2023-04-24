package com.jci.assignment.model.rbac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class CustomUserDetails {
    private String username;
    private String password;
    private boolean isActive;
    private String authorities;
}
