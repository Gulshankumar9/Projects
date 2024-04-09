package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class BoaUriApiAttriDefnId implements Serializable {
    private static final long serialVersionUID = -1006387190171844820L;
    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    private Integer entityId;

    @NotNull
    @Column(name = "CHANNEL_ID", nullable = false)
    private Integer channelId;

    @NotNull
    @Column(name = "ATTR_DEFN_ID", nullable = false)
    private Integer attrDefnId;

    @Size(max = 100)
    @NotNull
    @Column(name = "ATTR_NAME", nullable = false, length = 100)
    private String attrName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BoaUriApiAttriDefnId entity = (BoaUriApiAttriDefnId) o;
        return Objects.equals(this.attrDefnId, entity.attrDefnId) && Objects.equals(this.entityId, entity.entityId) && Objects.equals(this.channelId, entity.channelId) && Objects.equals(this.attrName, entity.attrName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attrDefnId, entityId, channelId, attrName);
    }

}