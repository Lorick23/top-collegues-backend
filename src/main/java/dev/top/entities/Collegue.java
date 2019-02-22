package dev.top.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.top.utils.CollegueAPI;

@Entity
public class Collegue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String photoUrl;
    @Column
    private int score;
    @Column
    private String matricule;

    public Collegue() {
    }

    public Collegue(String name, String photoUrl, int score) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.score = score;
    }

    public Collegue(CollegueAPI colapi) {
        this.name = colapi.getNom();
        this.photoUrl = colapi.getPhoto();
        this.score = 0;
        this.matricule = colapi.getMatricule();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getMatricule() {
        return this.matricule;
    }


}