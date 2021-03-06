package com.Kodem.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Certification> certifications;

    public User(){

    }
    public User(int id, String email, String username, String password) {
        super();
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
