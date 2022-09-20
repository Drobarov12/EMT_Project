package com.example.hotel.domain.modal.Hotel;

import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.hotel.domain.modal.reservation.ReservationId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

public class Hotel extends AbstractEntity<HotelId> {

    private HotelId hotelId;
    private String hotelName;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Reservation> reservationsList;

    public Reservation addReservation(@NotNull Reservation reservation){
        Objects.requireNonNull(reservation, "Reservation must not be null");
        reservationsList.add(reservation);
        return reservation;
    }

    public void removeReservation(@NotNull ReservationId reservationId) {
        Objects.requireNonNull(reservationId, "Reservation ID must not be null");
        reservationsList.removeIf(x -> x.getReservationId().equals(reservationId));
    }

}
