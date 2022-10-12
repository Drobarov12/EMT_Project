package com.example.timeduration.service;

import com.example.timeduration.domain.model.TimeDuration;
import com.example.timeduration.domain.model.TimeDurationId;
import com.example.timeduration.service.forms.TimeDurationForm;

import java.util.List;

public interface TimeDurationService {

    TimeDuration findById(TimeDurationId id);
    TimeDuration createTimeDuration(TimeDurationForm timeDurationForm);
    List<TimeDuration> getAll();

}
