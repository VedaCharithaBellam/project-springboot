package com.Kodem.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exp_id;
    private String exp_org;
    private String exp_role;
    private String exp_desc;
    private Date exp_start_date;
    private Date exp_end_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Experience(User user_id, int exp_id, String exp_org, String exp_role,String exp_desc, Date exp_start_date, Date exp_end_date) {
        this.user = user_id;
        this.exp_id = exp_id;
        this.exp_org = exp_org;
        this.exp_role = exp_role;
        this.exp_desc=exp_desc;
        this.exp_start_date = exp_start_date;
        this.exp_end_date = exp_end_date;

    }

    public Experience(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExp_desc() {
        return exp_desc;
    }

    public void setExp_desc(String exp_desc) {
        this.exp_desc = exp_desc;
    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }


    public String getExp_org() {
        return exp_org;
    }

    public void setExp_org(String exp_org) {
        this.exp_org = exp_org;
    }

    public String getExp_role() {
        return exp_role;
    }

    public void setExp_role(String exp_role) {
        this.exp_role = exp_role;
    }

    public Date getExp_start_date() {
        return exp_start_date;
    }

    public void setExp_start_date(Date exp_start_date) {
        this.exp_start_date = exp_start_date;
    }

    public Date getExp_end_date() {
        return exp_end_date;
    }

    public void setExp_end_date(Date exp_end_date) {
        this.exp_end_date = exp_end_date;
    }

}
