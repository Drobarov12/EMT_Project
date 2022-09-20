package com.example.hotel.service.forms;

import com.example.hotel.domain.modal.reservation.TypeOfRestourantReservation;
import com.example.hotel.domain.valueobjects.*;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class RestaurantForm {
    @NotNull
    private TypeOfRestourantReservation typeOfRestourantReservation;
    @NotNull
    private TimeDuration timeDuration;
    @NotNull
    private User user;
    @NotNull
    private int numberOfPeople;
}
