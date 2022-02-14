package com.Kodem.project.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int certification_id;
    private String certification_name;
    private String certification_desc;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Certification(){}

    public Certification(User user_id, int certification_id, String certification_name, String certification_desc) {
        this.user=user_id;
        this.certification_id = certification_id;
        this.certification_name = certification_name;
        this.certification_desc = certification_desc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCertification_id() {
        return certification_id;
    }

    public void setCertification_id(int certification_id) {
        this.certification_id = certification_id;
    }

    public String getCertification_name() {
        return certification_name;
    }

    public void setCertification_name(String certification_name) {
        this.certification_name = certification_name;
    }

    public String getCertification_desc() {
        return certification_desc;
    }

    public void setCertification_desc(String certification_desc) {
        this.certification_desc = certification_desc;
    }
}
