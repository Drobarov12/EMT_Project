package com.example.users.domain.module;

import com.example.sheredkernel.domain.base.AbstractEntity;
import com.example.sheredkernel.domain.location.Address;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "my_user")
public class User extends AbstractEntity<UserId> {

    private UserId userId;
    private String username;
    private String firstname;
    private String lastname;
    private Address address;

}
