package com.example.timeduration.domain.model;

import com.example.sheredkernel.domain.base.AbstractEntity;
import lombok.Getter;
import org.apache.tomcat.jni.Time;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Getter
public class TimeDuration extends AbstractEntity<TimeDurationId> {

    private TimeDurationId timeDurationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeDuration(TimeDurationId timeDurationId, LocalDateTime startTime, LocalDateTime endTime) {
        super(TimeDurationId.randomId(TimeDurationId.class));
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TimeDuration() {
        super(TimeDurationId.randomId(TimeDurationId.class));
        this.startTime = LocalDateTime.now(Clock.systemUTC());
        this.endTime = LocalDateTime.now(Clock.systemUTC());
    }

    public int timeDuration(){
        return this.startTime.getHour() - this.endTime.getHour();
    }

    public int dayDuration(){
        return this.startTime.getDayOfYear() - this.endTime.getDayOfYear();
    }


}
