package com.example.sheredkernel.domain.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.core.serializer.Serializer;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {

    private String ID;

    @JsonCreator
    protected DomainObjectId(@NotNull String uuid) {
        this.ID = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    /**
     * Creates a new, random instance of the given {@code idClass}.
     */
    @NotNull
    public static <ID extends DomainObjectId> ID randomId(@NotNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }


}
