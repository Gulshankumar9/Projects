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
@Table(name = "BOA_URI_OPENAPI_API_ATTR_DEFN")
public class BoaUriApiAttriDefn implements Serializable {
    @EmbeddedId
    private BoaUriApiAttriDefnId id;

    @Size(max = 300)
    @NotNull
    @Column(name = "SUMMARY", nullable = false, length = 300)
    private String summary;

    @Size(max = 1000)
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Size(max = 500)
    @Column(name = "DATA_TYPE", length = 500)
    private String dataType;

    @Column(name = "MANDATORY_FLAG")
    private Boolean mandatoryFlag;

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

    public Boolean getMandatoryFlag() {
        return mandatoryFlag;
    }

    public void setMandatoryFlag(Boolean mandatoryFlag) {
        this.mandatoryFlag = mandatoryFlag;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BoaUriApiAttriDefnId getId() {
        return id;
    }

    public void setId(BoaUriApiAttriDefnId id) {
        this.id = id;
    }
}