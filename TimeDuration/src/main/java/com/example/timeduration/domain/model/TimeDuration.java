package com.example.timeduration.domain.model;

import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
public class TimeDuration extends AbstractEntity<TimeDurationId> {

    private TimeDurationId timeDurationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double timeDuration;

}
