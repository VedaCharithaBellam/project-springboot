package com.Kodem.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String occupation;
    private String organisation;
    private String image;
    private String about;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Profile(){}

    public Profile(int id,String occupation, String organisation, String image, String about, User user) {
        this.id=id;
        this.occupation = occupation;
        this.organisation = organisation;
        this.image = image;
        this.about = about;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
