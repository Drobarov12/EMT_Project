package com.example.users.domain.models;

import com.example.sheredkernel.domain.base.AbstractEntity;
import com.example.sheredkernel.domain.location.Address;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "my_user")
public class User extends AbstractEntity<UserId> {

    private String username;
    private String firstname;
    private String lastname;
    private Address address;

    protected User(){
        super(UserId.randomId(UserId.class));
    }

    public static User create(String username, String firstname, String lastname, Address address) {
        User user = new User();
        user.username = username;
        user.firstname = firstname;
        user.lastname = lastname;
        user.address = address;
        return user;
    }
}
