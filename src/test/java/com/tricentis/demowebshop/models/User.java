package com.tricentis.demowebshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private final String gender;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
