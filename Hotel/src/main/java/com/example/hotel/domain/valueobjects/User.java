package com.example.hotel.domain.valueobjects;

import com.example.hotel.domain.valuesOf.UserId;
import com.example.sheredkernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class User implements ValueObject {
    private UserId id;
    private String username;
    private String name;
    private String surname;
    private String address;

    @JsonCreator
    public User(@JsonProperty("id") UserId id,
                @JsonProperty("username") String username,
                @JsonProperty("name") String name,
                @JsonProperty("surname") String surname,
                @JsonProperty("address") String address) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
