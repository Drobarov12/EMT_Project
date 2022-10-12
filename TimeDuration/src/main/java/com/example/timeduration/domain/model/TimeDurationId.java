package com.example.timeduration.domain.model;

import com.example.sheredkernel.domain.base.DomainObjectId;

public class TimeDurationId extends DomainObjectId {
    protected TimeDurationId(String uuid) {
        super(uuid);
    }

    public static TimeDurationId of(String uuid) {
        TimeDurationId t = new TimeDurationId(uuid);
        return t;
    }

}
