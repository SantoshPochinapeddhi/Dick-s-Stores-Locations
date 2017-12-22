package com.sample.dicksstores.model;

import java.io.Serializable;

public class Photos implements Serializable {
    private String photoId;

    private String createdAt;

    private String url;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPojo [photoId = " + photoId + ", createdAt = " + createdAt + ", url = " + url + "]";
    }
}