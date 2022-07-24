package com.example.hotel.domain.modal.reservation.numberOfRezervations;

import com.example.hotel.domain.valuesOf.UserId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class NumberOfReservations extends AbstractEntity<NumberOfReservationsId> {

    private NumberOfReservationsId numberOfReservationsId;
    private int numberOfReservations;
    private UserId userId;

}
