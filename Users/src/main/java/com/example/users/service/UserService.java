package com.example.users.service;

import com.example.users.domain.models.User;
import com.example.users.domain.models.UserId;
import com.example.users.service.UserForm.UserForm;

import java.util.List;

public interface UserService {
    User findById(UserId id);
    List<User> getAll();
    User create(UserForm userForm);
}
