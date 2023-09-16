package com.example.geekster.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAdmin {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long userAdminId;
    private String userAdminName;
    private String userAdminMobNo;
    private String userAdminEmail;
    private String userAdminPassword;

}