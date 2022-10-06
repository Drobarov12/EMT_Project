package com.example.timeduration.domain.model;

import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Getter
public class TimeDuration extends AbstractEntity<TimeDurationId> {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    protected TimeDuration() {
        super(TimeDurationId.randomId(TimeDurationId.class));
    }

    public static TimeDuration create(LocalDateTime startTime, LocalDateTime endTime) {
        TimeDuration timeDuration = new TimeDuration();
        timeDuration.startTime = startTime;
        timeDuration.endTime = endTime;
        return timeDuration;
    }

    public int timeDuration() {
        return this.startTime.getHour() - this.endTime.getHour();
    }

    public int dayDuration() {
        return this.startTime.getDayOfYear() - this.endTime.getDayOfYear();
    }
}
