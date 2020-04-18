package com.example.cs4550sp20filmpagesserver.models;

import javax.persistence.*;


@Entity
@Table(name = "moviegoers")
public class Moviegoer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @JsonIgnore
//    @ManyToOne
//    private List<Review> reviews;

    private Integer dob;

    // Constructor
    public Moviegoer(String name, Integer dob) {
        this.name = name;
        this.dob = dob;
    }


    public Moviegoer() {
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

    public void fillBlanks(Moviegoer other) {
        if (this.name == null) {
            this.name = other.name;
        }
        if (this.dob == null) {
            this.dob = other.dob;
        }
    }
}


