package com.Kodem.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int skill_id;
    private String skill_name;
    private String skill_level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Skill(){}

    public Skill(int skill_id, String skill_name, String skill_level, User user) {
        this.skill_id = skill_id;
        this.skill_name = skill_name;
        this.skill_level = skill_level;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(String skill_level) {
        this.skill_level = skill_level;
    }
}
