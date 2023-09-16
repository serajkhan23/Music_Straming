package com.example.geekster.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {
    @NotNull
    private String signInEmail;
    @NotNull
    private String signInPassword;
}