package com.internship.backend.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String password;

    public void setID(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            })
//    @JoinTable(name="User_Disease",
//            joinColumns = { @JoinColumn(name="id")},
//            inverseJoinColumns = {@JoinColumn(name="id")})
//    private Set<Disease> diseases = new HashSet<>();
//
//    public void removeDisease(long diseaseId) {
//        Disease disease = this.diseases.stream().filter(disease1 ->  disease1.getDisease_ID() == diseaseId).findFirst().orElse(null);
//        if (disease != null) this.diseases.remove(disease);
////        disease.get
//    }





}
