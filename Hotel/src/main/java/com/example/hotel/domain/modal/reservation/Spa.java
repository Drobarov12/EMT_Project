package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.valuesOf.Money;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Spa extends Reservation{

    private int numberOfBeds;
    private Money costOfTheSpaReservation;

}
