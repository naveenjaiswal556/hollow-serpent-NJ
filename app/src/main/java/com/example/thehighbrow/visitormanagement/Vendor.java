package com.example.thehighbrow.visitormanagement;

import android.net.Uri;

class Vendor {

    String name;
    String contact;
    String host;
    String photoUrl;


    void Vendor() {

    }

    public Vendor() {
    }

    public Vendor(String name, String contact, String host, String photoUrl){
        this.name = name;
        this.contact = contact;
        this.host = host;
        this.photoUrl = photoUrl;

    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getHost() {
        return host;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
