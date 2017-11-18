package com.epam.lab.payments.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private boolean isAdmin;

    private String oper;
}


