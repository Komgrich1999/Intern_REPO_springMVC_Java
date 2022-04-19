package com.internship.backend.model;

import javax.persistence.*;

@Entity
public class disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String diseaseName;
// private Object disease_data;
    // private <FILE OF DISEASE DATA LOCATION>
    private String fileLocation;

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

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public void setFileLocation(String fileLocation) { this.fileLocation = fileLocation; }

    public long getDisease_ID() {
        return id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public String getFileLocation() {
        return fileLocation;
    }

//    public Set<User> getUser() {
//        return users;
//    }
//
//    public void setUser(Set<User> users) {
//        this.users = users;
//    }


}
