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
public class BoaUriApiRqDefnId implements Serializable {
    private static final long serialVersionUID = -4204585395867253401L;
    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    private Integer entityId;

    @NotNull
    @Column(name = "CHANNEL_ID", nullable = false)
    private Integer channelId;

    @NotNull
    @Column(name = "DEFN_ID", nullable = false)
    private Integer defnId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoaUriApiRqDefnId entity = (BoaUriApiRqDefnId) o;
        return Objects.equals(this.defnId, entity.defnId) && Objects.equals(this.entityId, entity.entityId) && Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defnId, entityId, channelId);
    }

}