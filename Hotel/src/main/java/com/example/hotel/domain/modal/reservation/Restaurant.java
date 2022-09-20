package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.hotel.domain.valuesOf.UserId;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Time;

@Entity
@Getter
public class Restaurant extends Reservation {

    @Enumerated(value = EnumType.STRING)
    private TypeOfRestourantReservation typeOfRestourantReservation;

    public Restaurant(TypeOfRestourantReservation type,UserId userId, TimeDurationId timeDurationId, int peopleNumber) {
        super(userId, timeDurationId, peopleNumber);
        this.typeOfRestourantReservation = type;
    }

    protected Restaurant() {
        super();
        this.typeOfRestourantReservation = TypeOfRestourantReservation.BREAKFAST;
    }
}
