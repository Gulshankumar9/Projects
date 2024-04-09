package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class BoaUriApiDefnId implements Serializable {
    private static final long serialVersionUID = -3766340625657530466L;
    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    private Integer entityId;

    @NotNull
    @Column(name = "CHANNEL_ID", nullable = false)
    private Integer channelId;

    @NotNull
    @Column(name = "URI_ID", nullable = false)
    private Integer uriId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoaUriApiDefnId entity = (BoaUriApiDefnId) o;
        return Objects.equals(this.uriId, entity.uriId) && Objects.equals(this.entityId, entity.entityId) && Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uriId, entityId, channelId);
    }

}