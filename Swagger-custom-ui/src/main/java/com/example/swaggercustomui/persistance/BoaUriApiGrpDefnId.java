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
public class BoaUriApiGrpDefnId implements Serializable {
    private static final long serialVersionUID = 3160278285259389843L;
    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    private Integer entityId;

    @NotNull
    @Column(name = "CHANNEL_ID", nullable = false)
    private Integer channelId;

    @NotNull
    @Column(name = "GROUP_ID", nullable = false)
    private Integer groupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoaUriApiGrpDefnId entity = (BoaUriApiGrpDefnId) o;
        return Objects.equals(this.groupId, entity.groupId) && Objects.equals(this.entityId, entity.entityId) && Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, entityId, channelId);
    }

}