package com.example.hotel.domain.modal.reservation;

import com.example.sheredkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId extends DomainObjectId {

    protected ReservationId(String uuid) {
        super(uuid);
    }

    public ReservationId() {
        super(ReservationId.randomId(ReservationId.class).getID());
    }
}
