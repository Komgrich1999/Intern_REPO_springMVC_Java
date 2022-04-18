package com.internship.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String disease_name;
// private Object disease_data;
    // private <FILE OF DISEASE DATA LOCATION>
    private String FILE_LOCATION;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },mappedBy = "disease")
//    @JsonIgnore
//    private Set<User> users = new HashSet<>();

    public void setDisease_ID(long id) {
        this.id = id;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public void setFILE_LOCATION(String FILE_LOCATION) { this.FILE_LOCATION = FILE_LOCATION; }

    public long getDisease_ID() {
        return id;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public String getFILE_LOCATION() {
        return FILE_LOCATION;
    }

//    public Set<User> getUser() {
//        return users;
//    }
//
//    public void setUser(Set<User> users) {
//        this.users = users;
//    }


}
