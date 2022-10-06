package com.example.users.service.UserForm;

import com.example.sheredkernel.domain.location.Address;
import lombok.Data;

@Data
public class UserForm {
    private String username;
    private String firstname;
    private String lastname;
    private Address address;
}
