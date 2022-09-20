package com.example.hotel.domain.valueobjects;

import com.example.hotel.domain.modal.Hotel.TimeDurationId;
import com.example.sheredkernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class TimeDuration implements ValueObject {
    private TimeDurationId id;
    private LocalDateTime starTime;
    private LocalDateTime endTime;

    @JsonCreator
    public TimeDuration(@JsonProperty("id") TimeDurationId id,
                        @JsonProperty("startTime") LocalDateTime starTime,
                        @JsonProperty("endTime") LocalDateTime endTime) {
        this.id = id;
        this.starTime = starTime;
        this.endTime = endTime;
    }
}
