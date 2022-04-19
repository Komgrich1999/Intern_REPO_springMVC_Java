package com.internship.backend.model;

import javax.persistence.*;

@Entity
public class healthCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String HC_name;
    private String HC_town;


    public long getHC_ID() {
        return id;
    }

    public void setHC_ID(long id) {
        this.id = id;
    }

    public String getHC_name() {
        return HC_name;
    }

    public void setHC_name(String HC_name) {
        this.HC_name = HC_name;
    }

    public String getHC_town() {
        return HC_town;
    }

    public void setHC_town(String HC_town) {
        this.HC_town = HC_town;
    }


}
