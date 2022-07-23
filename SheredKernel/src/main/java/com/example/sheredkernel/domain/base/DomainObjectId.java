package com.example.sheredkernel.domain.base;

import lombok.Getter;
import org.springframework.core.serializer.Serializer;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {

    private String ID;

}
