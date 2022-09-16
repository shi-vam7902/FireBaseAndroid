package com.royal.firebaseimplementation;

public class ContactModel {
    String id;
    String lname;
    String fname;

    public ContactModel(String id, String lname, String fname) {
        this.id = id;
        this.lname = lname;
        this.fname = fname;
    }

    public ContactModel() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
