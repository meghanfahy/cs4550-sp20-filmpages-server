package com.example.cs4550sp20filmpagesserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USR_TYPE")
@Entity
@Table(name = "moviegoers")
public class Moviegoer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore // What's the best way to do this?
    private String password;

    private String username;

    private String name;
    private Integer dob;

    public Moviegoer(String name, Integer dob,
                     String password, String username) {
        this.name = name;
        this.dob = dob;
        this.password = password;
        this.username = username;
    }

    public Moviegoer() {
    }

    public void fillBlanks(Moviegoer other) {
        if (this.name == null) {
            this.name = other.name;
        }
        if (this.dob == null) {
            this.dob = other.dob;
        }
        if (this.username == null) {
            this.username = other.username;
        }
        if (this.password == null) {
            this.password = other.password;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }
}


