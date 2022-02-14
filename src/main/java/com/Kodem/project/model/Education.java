package com.Kodem.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int edu_id;
    private String edu_org;
    private String edu_stream;
    private Date edu_start_date;
    private Date edu_end_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Education(User user_id, int edu_id, String edu_org, String edu_stream, Date edu_start_date, Date edu_end_date) {
        this.user = user_id;
        this.edu_id = edu_id;
        this.edu_org = edu_org;
        this.edu_stream = edu_stream;
        this.edu_start_date = edu_start_date;
        this.edu_end_date = edu_end_date;

    }

    public Education(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(int edu_id) {
        this.edu_id = edu_id;
    }

    public String getEdu_org() {
        return edu_org;
    }

    public void setEdu_org(String edu_org) {
        this.edu_org = edu_org;
    }

    public String getEdu_stream() {
        return edu_stream;
    }

    public void setEdu_stream(String edu_stream) {
        this.edu_stream = edu_stream;
    }

    public Date getEdu_start_date() {
        return edu_start_date;
    }

    public void setEdu_start_date(Date edu_start_date) {
        this.edu_start_date = edu_start_date;
    }

    public Date getEdu_end_date() {
        return edu_end_date;
    }

    public void setEdu_end_date(Date edu_end_date) {
        this.edu_end_date = edu_end_date;
    }
}
