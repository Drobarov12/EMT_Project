package com.example.hotel.service.forms;

import com.example.hotel.domain.valueobjects.*;
import com.example.hotel.domain.valuesOf.MoneyCurrency;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class SpaForm {
    @NotNull
    private MoneyCurrency moneyCurrency;
    @NotNull
    @Min(1)
    private int numOfBeds;
    @NotNull
    @Min(1)
    private int peopleNumber;
    @NotNull
    @Min(5)
    private int pricePerBed;
    @NotNull
    private TimeDuration timeDuration;
    @NotNull
    private User user;
}
