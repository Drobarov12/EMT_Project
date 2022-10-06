package com.example.timeduration.domain.repository;

import com.example.timeduration.domain.model.TimeDuration;
import com.example.timeduration.domain.model.TimeDurationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeDurationRepository extends JpaRepository<TimeDuration, TimeDurationId> {
}
