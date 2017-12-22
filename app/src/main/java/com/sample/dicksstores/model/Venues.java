package com.sample.dicksstores.model;

import java.io.Serializable;

public class Venues implements Serializable {
    private Photos[] photos;

    private String id;

    private String ratingSignals;

    private Location location;

    private String ratingColor;

    private String verified;

    private String name;

    private String rating;

    private String storeId;

    private String url;

    private Contacts[] contacts;

    public Photos[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photos[] photos) {
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRatingSignals() {
        return ratingSignals;
    }

    public void setRatingSignals(String ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Contacts[] getContacts() {
        return contacts;
    }

    public void setContacts(Contacts[] contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ClassPojo [photos = " + photos + ", id = " + id + ", ratingSignals = " + ratingSignals + ", location = " + location + ", ratingColor = " + ratingColor + ", verified = " + verified + ", name = " + name + ", rating = " + rating + ", storeId = " + storeId + ", url = " + url + ", contacts = " + contacts + "]";
    }
}