package com.example.hotel.domain.modal.reservation.numberOfRezervations;

import com.example.sheredkernel.domain.base.DomainObjectId;

public class NumberOfReservationsId extends DomainObjectId {
    protected NumberOfReservationsId(String uuid) {
        super(uuid);
    }

    private NumberOfReservationsId() {
        super(NumberOfReservationsId.randomId(NumberOfReservationsId.class).getID());
    }


}
