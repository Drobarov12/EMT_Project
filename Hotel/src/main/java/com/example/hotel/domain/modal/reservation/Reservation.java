package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.hotel.domain.modal.reservation.numberOfRezervations.NumberOfReservations;
import com.example.hotel.domain.valuesOf.UserId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
public abstract class Reservation extends AbstractEntity<ReservationId> {

    private ReservationId reservationId;

    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;

    @AttributeOverride(name = "id", column = @Column(name = "time_duration_id"))
    private TimeDurationId timeDurationId;

    private int peopleNumber;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<NumberOfReservations> numberOfReservationsList;

}
