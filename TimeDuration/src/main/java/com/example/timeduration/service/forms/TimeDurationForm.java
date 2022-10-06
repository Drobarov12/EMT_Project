package com.example.timeduration.service.forms;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeDurationForm {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
