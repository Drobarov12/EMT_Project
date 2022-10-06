package com.example.hotel.domain.modal.Hotel;

import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.hotel.domain.modal.reservation.ReservationId;
import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
public class Hotel extends AbstractEntity<HotelId> {

    private String hotelName;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Reservation> reservationsList;

    protected Hotel() {
        super(HotelId.randomId(HotelId.class));
    }

    public static Hotel create(String hotelName){
        Hotel hotel = new Hotel();
        hotel.hotelName = hotelName;
        hotel.reservationsList = new HashSet<>();
        return hotel;
    }
}
