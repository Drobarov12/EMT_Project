package com.example.timeduration.xport.rest;

import com.example.timeduration.domain.model.TimeDuration;
import com.example.timeduration.domain.model.TimeDurationId;
import com.example.timeduration.service.TimeDurationService;
import com.example.timeduration.service.forms.TimeDurationForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time_duration")
@AllArgsConstructor
public class TimeDurationResource {
    private final TimeDurationService timeDurationService;

    @GetMapping
    public List<TimeDuration> getAll(){
        return this.timeDurationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDuration> getTimeDuration(@PathVariable String timeDurationId){
        var temp = this.timeDurationService.findById(TimeDurationId.of(timeDurationId));
        if(temp != null)
            return ResponseEntity.ok().body(temp);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<TimeDuration> addTimeDuration(@RequestBody TimeDurationForm timeDurationForm){
        var temp = this.timeDurationService.createTimeDuration(timeDurationForm);
        if(temp != null)
            return ResponseEntity.ok().body(temp);
        return ResponseEntity.badRequest().build();
    }
}
