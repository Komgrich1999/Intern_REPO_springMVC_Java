package com.internship.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;
    private boolean isAdmit ;

    Patient(){ }

    public Patient(String description, boolean isAdmit){
        this.description = description;
        this.isAdmit = isAdmit;
    }

    public void setPatient_HN(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsAdmit(boolean admit) {
        isAdmit = admit;
    }

    public long getPatient_HN() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsAdmit() {
        return isAdmit;
    }
}
