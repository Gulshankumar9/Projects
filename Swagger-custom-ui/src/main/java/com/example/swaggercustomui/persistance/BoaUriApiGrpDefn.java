package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "BOA_URI_OPENAPI_GRP_DEFN")
public class BoaUriApiGrpDefn implements Serializable {
    @EmbeddedId
    private BoaUriApiGrpDefnId id;

    @NotNull
    @Column(name = "DOC_ID", nullable = false)
    private Integer docId;

    @Size(max = 300)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 300)
    private String name;

    @Size(max = 1000)
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "VERSION_NO")
    private Integer versionNo;

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public BoaUriApiGrpDefnId getId() {
        return id;
    }

    public void setId(BoaUriApiGrpDefnId id) {
        this.id = id;
    }
}