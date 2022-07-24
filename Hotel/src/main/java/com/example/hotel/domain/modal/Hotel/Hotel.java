package com.example.hotel.domain.modal.Hotel;

import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.sheredkernel.domain.base.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

public class Hotel extends AbstractEntity<HotelId> {

    private HotelId hotelId;
    private String hotelName;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Reservation> reservationsList;

}
