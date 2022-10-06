package com.example.users.service.impl;

import com.example.users.domain.exeptions.UserNotFound;
import com.example.users.domain.models.User;
import com.example.users.domain.models.UserId;
import com.example.users.domain.repository.UserRepository;
import com.example.users.service.UserForm.UserForm;
import com.example.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(UserId id) {
        return userRepository.findById(id).orElseThrow(UserNotFound::new);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserForm userForm) {
        User user = User.create(userForm.getUsername(), userForm.getFirstname(), userForm.getLastname(), userForm.getAddress());
        userRepository.save(user);
        return user;
    }
}
