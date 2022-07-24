package com.example.hotel.domain.modal.reservation;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
public class Restaurant extends Reservation {

    @Enumerated(value = EnumType.STRING)
    private TypeOfRestourantReservation typeOfRestourantReservation;

}
