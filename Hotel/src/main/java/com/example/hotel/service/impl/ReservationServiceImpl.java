package com.example.hotel.service.impl;

import com.example.hotel.domain.exeptions.ReservationIdNotFound;
import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.hotel.domain.modal.reservation.ReservationId;
import com.example.hotel.domain.modal.reservation.Spa;
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
        var newReservation = reservationRepository.saveAndFlush(toDomainObject(spaForm));

        return null;
    }

    @Override
    public Reservation createRestaurantReservation(RestaurantForm restaurantForm) {
        return null;
    }

    @Override
    public Reservation createRoomReservation(RoomForm roomForm) {
        return null;
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
    public void deleteReservation(ReservationId reservationId) throws ReservationIdNotFound {

    }

    private Spa toDomainObject(SpaForm spaForm){
        var spa = new Spa(spaForm.getNumOfBeds(),spaForm.getMoneyCurrency(),spaForm.getUser().getId(),spaForm.getTimeDuration().getId(), spaForm.getPeopleNumber());
        spa.cost(spaForm.getPricePerBed());
        return spa;
    }
}
