package com.example.hotel.service.forms;

import com.example.hotel.domain.modal.reservation.TypeOfRestourantReservation;
import com.example.hotel.domain.valueobjects.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
public class RestaurantForm {

    @NotNull
    private TypeOfRestourantReservation typeOfRestourantReservation;
    @NotNull
    private TimeDuration timeDuration;
    @NotNull
    private User user;

}
