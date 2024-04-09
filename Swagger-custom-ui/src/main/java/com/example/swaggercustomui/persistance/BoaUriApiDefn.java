package com.example.swaggercustomui.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "BOA_URI_OPENAPI_API_DEFN")
public class BoaUriApiDefn implements java.io.Serializable {


    @EmbeddedId
    private BoaUriApiDefnId id;

    @NotNull
    @Column(name = "GROUP_ID", nullable = false)
    private Integer groupId;

    @Size(max = 100)
    @NotNull
    @Column(name = "URI_PATH", nullable = false, length = 100)
    private String uriPath;

    @Size(max = 300)
    @NotNull
    @Column(name = "SUMMARY", nullable = false, length = 300)
    private String summary;

    @Size(max = 1000)
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Size(max = 10)
    @NotNull
    @Column(name = "HTTP_METHOD", nullable = false, length = 10)
    private String httpMethod;

    @Column(name = "REQ_DEFN_ID")
    private Integer reqDefnId;

    @Column(name = "RES_DEFN_ID")
    private Integer resDefnId;

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

    public Integer getResDefnId() {
        return resDefnId;
    }

    public void setResDefnId(Integer resDefnId) {
        this.resDefnId = resDefnId;
    }

    public Integer getReqDefnId() {
        return reqDefnId;
    }

    public void setReqDefnId(Integer reqDefnId) {
        this.reqDefnId = reqDefnId;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
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

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public BoaUriApiDefnId getId() {
        return id;
    }

    public void setId(BoaUriApiDefnId id) {
        this.id = id;
    }
}