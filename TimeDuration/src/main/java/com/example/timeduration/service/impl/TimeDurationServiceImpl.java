package com.example.timeduration.service.impl;

import com.example.timeduration.domain.TimeDurationNotFound;
import com.example.timeduration.domain.model.TimeDuration;
import com.example.timeduration.domain.model.TimeDurationId;
import com.example.timeduration.domain.repository.TimeDurationRepository;
import com.example.timeduration.service.TimeDurationService;
import com.example.timeduration.service.forms.TimeDurationForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class TimeDurationServiceImpl implements TimeDurationService {

    private final TimeDurationRepository timeDurationRepository;

    @Override
    public TimeDuration findById(TimeDurationId id) {
        return timeDurationRepository.findById(id).orElseThrow(TimeDurationNotFound::new);
    }

    @Override
    public TimeDuration createTimeDuration(TimeDurationForm timeDurationForm) {
        TimeDuration timeDuration = TimeDuration.create(timeDurationForm.getStartTime(), timeDurationForm.getEndTime());
        timeDurationRepository.save(timeDuration);
        return timeDuration;
    }

    @Override
    public List<TimeDuration> getAll() {
        return timeDurationRepository.findAll();
    }
}
