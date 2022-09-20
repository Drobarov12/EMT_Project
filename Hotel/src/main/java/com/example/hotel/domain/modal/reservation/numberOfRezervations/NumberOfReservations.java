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


    public NumberOfReservations(UserId userId) {
        super(NumberOfReservationsId.randomId(NumberOfReservationsId.class));
        this.numberOfReservations = 0;
        this.userId = userId;
    }

    public NumberOfReservations() {
        super(NumberOfReservationsId.randomId(NumberOfReservationsId.class));
        this.userId = UserId.randomId(UserId.class);
        this.numberOfReservations = -100;
    }

    public void addedReservations(){
        this.numberOfReservations += 1;
    }

    public void removeReservation(){
        this.numberOfReservations -= 1;
    }


}
