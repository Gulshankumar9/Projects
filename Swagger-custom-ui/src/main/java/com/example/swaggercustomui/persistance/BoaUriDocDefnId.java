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
public class BoaUriDocDefnId implements Serializable {
    private static final long serialVersionUID = -3301705842723568589L;
    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    private Integer entityId;

    @NotNull
    @Column(name = "CHANNEL_ID", nullable = false)
    private Integer channelId;

    @NotNull
    @Column(name = "DOC_ID", nullable = false)
    private Integer docId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoaUriDocDefnId entity = (BoaUriDocDefnId) o;
        return Objects.equals(this.docId, entity.docId) && Objects.equals(this.entityId, entity.entityId) && Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId, entityId, channelId);
    }

}