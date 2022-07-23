package com.example.sheredkernel.domain.location;

import com.example.sheredkernel.domain.base.ValueObject;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String state;
    private final String city;
    private final String street;
    private final String streetNumber;

    protected Address(){
        this.state = "";
        this.city = "";
        this.street = "";
        this.streetNumber = "";
    }

    public Address(
            @NotNull String state,
            @NotNull String city,
            @NotNull String street,
            @NotNull String streetNumber) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}
