package com.example.hotel.domain.modal.reservation;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.hotel.domain.modal.reservation.numberOfRezervations.NumberOfReservations;
import com.example.hotel.domain.valuesOf.Money;
import com.example.hotel.domain.valuesOf.MoneyCurrency;
import com.example.hotel.domain.valuesOf.UserId;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@Entity
@Getter
public class Spa extends Reservation {

    private int numberOfBeds = -100;

    @Column(name = "reservation_currency")
    @Enumerated(EnumType.STRING)
    private MoneyCurrency moneyCurrency = MoneyCurrency.MKD;

    public Spa(int numberOfBeds, MoneyCurrency moneyCurrency, UserId userId, TimeDurationId timeDurationId, int peopleNumber) {
        super(userId, timeDurationId, peopleNumber);
        this.numberOfBeds = numberOfBeds;
        this.moneyCurrency = moneyCurrency;
    }

    public Spa() {
        super();
    }

    public Money cost(double value) {
        Money valuePerBed = new Money(moneyCurrency, value);
        return valuePerBed.Multiply(numberOfBeds);
    }
}
