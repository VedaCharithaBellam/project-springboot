package com.Kodem.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
public class Certification {

    @Id
    private int certification_id;
    private String certification_name;
    private String certification_desc;

    @OneToMany(mappedBy = "certification")
    private List<User> users;

    public Certification(){}

    public Certification(int certification_id, String certification_name, String certification_desc) {
        this.certification_id = certification_id;
        this.certification_name = certification_name;
        this.certification_desc = certification_desc;
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
