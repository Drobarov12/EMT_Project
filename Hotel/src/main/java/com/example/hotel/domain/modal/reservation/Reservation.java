package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.hotel.domain.modal.Hotel.UserId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public abstract class Reservation extends AbstractEntity<ReservationId> {

    private ReservationId reservationId;

    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;

    @AttributeOverride(name = "id", column = @Column(name = "time_duration_id"))
    private TimeDurationId timeDurationId;

    private int peopleNumber;

}
