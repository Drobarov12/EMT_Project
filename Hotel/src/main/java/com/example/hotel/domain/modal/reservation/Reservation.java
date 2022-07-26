package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.hotel.domain.modal.reservation.numberOfRezervations.NumberOfReservations;
import com.example.hotel.domain.valuesOf.UserId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private UserId userId;

    @AttributeOverride(name = "id", column = @Column(name = "time_duration_id"))
    private TimeDurationId timeDurationId;

    private int peopleNumber;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<NumberOfReservations> nunmberOfReservatiosList = new HashSet<>();


    public static Reservation create(UserId userId, TimeDurationId timeDurationId, int peopleNumber) {
        Reservation reservation = new Reservation();
        reservation.userId = userId;
        reservation.timeDurationId = timeDurationId;
        reservation.peopleNumber = peopleNumber;
        var temp = new NumberOfReservations(userId);
        reservation.nunmberOfReservatiosList.add(temp);
        return reservation;
    }

    public Reservation(UserId userId, TimeDurationId timeDurationId, int peopleNumber) {
        super(ReservationId.randomId(ReservationId.class));
        this.userId = userId;
        this.timeDurationId = timeDurationId;
        this.peopleNumber = peopleNumber;
    }

    public Reservation() {
        super(ReservationId.randomId(ReservationId.class));
    }
}
