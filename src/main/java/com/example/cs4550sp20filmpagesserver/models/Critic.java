package com.example.cs4550sp20filmpagesserver.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Critic extends Moviegoer {

    // Stuff particular to Critics.
    // e.g. reviews/ratings

}
