package com.contactmanager.model;

public class Contact {
    private String strgName;
    private String phNo;
    private String mailId;

    public Contact(String name, String phone, String email) {
        this.strgName = strgName;
        this.phNo = phNo;
        this.mailId = mailId;
    }

    public String getStrgName() {
        return name;
    }

    public String getPhNo() {
        return phone;
    }

    public String getMailId() {
        return email;
    }
}
