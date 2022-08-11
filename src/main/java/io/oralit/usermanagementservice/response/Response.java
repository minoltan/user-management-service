package io.oralit.usermanagementservice.response;

import java.util.Date;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public class Response {
    private String language = "en";
    private String statusInfo;
    private String entityType;
    private Date lastModified;
    private Object data;
    private boolean success = true;
    private String errorMessage;
    private String requestedURI;

    public Response() {
        this.lastModified = new Date();
    }

    public Response(Object data) {
        this.data = data;
        this.lastModified = new Date();
        this.entityType = data.getClass().toString();
    }

    public Response(Object data, String statusInfo) {
        this.data = data;
        this.statusInfo = statusInfo;
        this.lastModified = new Date();
        this.entityType = data.getClass().toString();
    }

    public Response(String language, String statusInfo, String entityType, Date lastModified, Object data) {
        this.language = language;
        this.statusInfo = statusInfo;
        this.entityType = entityType;
        this.lastModified = lastModified;
        this.data = data;
    }

    public String toString() {
        return "Response{data=" + this.data + "}";
    }

    public String getLanguage() {
        return this.language;
    }

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public Object getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getRequestedURI() {
        return this.requestedURI;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setRequestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
