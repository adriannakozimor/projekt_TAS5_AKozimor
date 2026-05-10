package com.tricentis.demowebshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    String gender;
    String firstName;
    String lastName;
    String email;
    String password;
}
