package com.example.hotel.service.impl;

import com.example.hotel.domain.exeptions.ReservationIdNotFound;
import com.example.hotel.domain.modal.reservation.*;
import com.example.hotel.domain.repository.ReservationRepository;
import com.example.hotel.service.ReservationService;
import com.example.hotel.service.forms.RestaurantForm;
import com.example.hotel.service.forms.RoomForm;
import com.example.hotel.service.forms.SpaForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final Validator validator;

    @Override
    public Reservation createSpaReservation(SpaForm spaForm) {
        Objects.requireNonNull(spaForm, "SpaForm must not be null");
        var constraints = validator.validate(spaForm);
        if(constraints.size()>0)
            throw new ConstraintViolationException("Spa reservation is not valid.",constraints);
        var newReservation = reservationRepository.saveAndFlush(spaToDomainObject(spaForm));

        return newReservation;
    }

    @Override
    public Reservation createRestaurantReservation(RestaurantForm restaurantForm) {
        Objects.requireNonNull(restaurantForm, "Restaurant Form must not be null");
        var constraints = validator.validate(restaurantForm);
        if(constraints.size()>0)
            throw new ConstraintViolationException("Restaurant reservation is not valid.",constraints);
        var newReservation = reservationRepository.saveAndFlush(restaurantToDomainObject(restaurantForm));

        return newReservation;
    }

    @Override
    public Reservation createRoomReservation(RoomForm roomForm) {
        Objects.requireNonNull(roomForm, "Room Form must not be null");
        var constraints = validator.validate(roomForm);
        if(constraints.size()>0)
            throw new ConstraintViolationException("Room reservation is not valid.",constraints);
        var newReservation = reservationRepository.saveAndFlush(roomToDomainObject(roomForm));

        return newReservation;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findReservationById(ReservationId reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void deleteReservation(ReservationId reservationId){
        reservationRepository.deleteById(reservationId);
    }

    private Spa spaToDomainObject(SpaForm spaForm){
        var spa = new Spa(spaForm.getNumOfBeds(),spaForm.getMoneyCurrency(),spaForm.getUser().getId(),spaForm.getTimeDuration().getId(), spaForm.getPeopleNumber());
        spa.cost(spaForm.getPricePerBed());
        return spa;
    }

    private Room roomToDomainObject(RoomForm roomForm){
        var room = new Room(roomForm.getNumOfBeds(),roomForm.getMoneyCurrency(),roomForm.getUser().getId(), roomForm.getTimeDuration().getId(),roomForm.getNumOfPeople());
        room.cost(roomForm.getPricePerBed());
        return room;
    }

    private Restaurant restaurantToDomainObject(RestaurantForm restaurantForm){
        var restaurant = new Restaurant(restaurantForm.getTypeOfRestourantReservation(),restaurantForm.getUser().getId(),restaurantForm.getTimeDuration().getId(), restaurantForm.getNumberOfPeople());
        return restaurant;
    }
}
