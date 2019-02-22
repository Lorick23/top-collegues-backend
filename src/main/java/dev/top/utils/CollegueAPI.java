package dev.top.utils;

public class CollegueAPI{

    private String matricule;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private String photo;


    public String getMatricule() {
        return this.matricule;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getMail() {
        return this.mail;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getPhoto() {
        return this.photo;
    }

	public void setPhoto(String photo) {
        this.photo = photo;
    }

	public void setNom(String nom) {
        this.nom = nom;
    }



}