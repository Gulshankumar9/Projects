package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "BOA_URI_OPENAPI_API_RQ_DEFN")
public class BoaUriApiRqDefn implements java.io.Serializable {
    @EmbeddedId
    private BoaUriApiRqDefnId id;

    @Size(max = 200)
    @NotNull
    @Column(name = "MEDIA_TYPE", nullable = false, length = 200)
    private String mediaType;

    @Column(name = "HEADER_ATTR_DEFN_ID")
    private Integer headerAttrDefnId;

    @Column(name = "QUERY_PARAM_ATTR_DEFN_ID")
    private Integer queryParamAttrDefnId;

    @Column(name = "PATH_PARAM_ATTR_DEFN_ID")
    private Integer pathParamAttrDefnId;

    @Column(name = "BODY_ATTR_DEFN_ID")
    private Integer bodyAttrDefnId;

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

    public Integer getBodyAttrDefnId() {
        return bodyAttrDefnId;
    }

    public void setBodyAttrDefnId(Integer bodyAttrDefnId) {
        this.bodyAttrDefnId = bodyAttrDefnId;
    }

    public Integer getPathParamAttrDefnId() {
        return pathParamAttrDefnId;
    }

    public void setPathParamAttrDefnId(Integer pathParamAttrDefnId) {
        this.pathParamAttrDefnId = pathParamAttrDefnId;
    }

    public Integer getQueryParamAttrDefnId() {
        return queryParamAttrDefnId;
    }

    public void setQueryParamAttrDefnId(Integer queryParamAttrDefnId) {
        this.queryParamAttrDefnId = queryParamAttrDefnId;
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

    public BoaUriApiRqDefnId getId() {
        return id;
    }

    public void setId(BoaUriApiRqDefnId id) {
        this.id = id;
    }
}