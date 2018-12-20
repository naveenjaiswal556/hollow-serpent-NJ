package com.example.thehighbrow.visitormanagement;

import android.net.Uri;

public class DayVisitor {
    String name;
    String contact;
    String email;
    String photoUrl;
    String gst;
    String invoice;
    Uri photouri;

    void dayVisitor(){

    }

    public DayVisitor(){}

    public DayVisitor(String name, String contact, String email,String gst, String invoice, String photoUrl){
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.photoUrl= photoUrl;
        this.gst= gst;
        this.invoice= invoice;

    }


    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getGst() {
        return gst;
    }

    public String getInvoice() {
        return invoice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setHost(String host) {
        this.email = host;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
