package com.example.hotel.domain.valuesOf;

import com.example.sheredkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {
    protected UserId(String uuid) {
        super(uuid);
    }

    private UserId() {
        super(UserId.randomId(UserId.class).getID());
    }

}
