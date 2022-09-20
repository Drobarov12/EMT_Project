package com.example.hotel.service;

import com.example.hotel.domain.exeptions.ReservationIdNotFound;
import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.hotel.domain.modal.reservation.ReservationId;
import com.example.hotel.service.forms.RestaurantForm;
import com.example.hotel.service.forms.RoomForm;
import com.example.hotel.service.forms.SpaForm;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation createSpaReservation(SpaForm spaForm);
    Reservation createRestaurantReservation(RestaurantForm restaurantForm);
    Reservation createRoomReservation(RoomForm roomForm);
    List<Reservation> findAllReservations();
    Optional<Reservation> findReservationById(ReservationId reservationId);
    void deleteReservation(ReservationId reservationId) throws ReservationIdNotFound;
}
