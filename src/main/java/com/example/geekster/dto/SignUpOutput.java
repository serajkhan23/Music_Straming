package com.example.geekster.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpOutput {
    private boolean SignUpStatus;
    private String SignUpMsg;

}