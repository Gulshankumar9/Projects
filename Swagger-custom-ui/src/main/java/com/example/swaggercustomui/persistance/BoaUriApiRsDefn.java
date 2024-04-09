package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "BOA_URI_OPENAPI_API_RS_DEFN")
public class BoaUriApiRsDefn implements java.io.Serializable {
    @EmbeddedId
    private BoaUriApiRsDefnId id;

    @Size(max = 200)
    @NotNull
    @Column(name = "MEDIA_TYPE", nullable = false, length = 200)
    private String mediaType;

    @Column(name = "HEADER_ATTR_DEFN_ID")
    private Integer headerAttrDefnId;

    @Column(name = "BODY_SUCCESS_ATTR_DEFN_ID")
    private Integer bodySuccessAttrDefnId;

    @Column(name = "BODY_FAILURE_ATTR_DEFN_ID")
    private Integer bodyFailureAttrDefnId;

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

    public Integer getBodyFailureAttrDefnId() {
        return bodyFailureAttrDefnId;
    }

    public void setBodyFailureAttrDefnId(Integer bodyFailureAttrDefnId) {
        this.bodyFailureAttrDefnId = bodyFailureAttrDefnId;
    }

    public Integer getBodySuccessAttrDefnId() {
        return bodySuccessAttrDefnId;
    }

    public void setBodySuccessAttrDefnId(Integer bodySuccessAttrDefnId) {
        this.bodySuccessAttrDefnId = bodySuccessAttrDefnId;
    }

    public Integer getHeaderAttrDefnId() {
        return headerAttrDefnId;
    }

    public void setHeaderAttrDefnId(Integer headerAttrDefnId) {
        this.headerAttrDefnId = headerAttrDefnId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public BoaUriApiRsDefnId getId() {
        return id;
    }

    public void setId(BoaUriApiRsDefnId id) {
        this.id = id;
    }
}