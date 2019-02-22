package dev.top.utils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CollegueFront{

    @NotNull
    @Size(min=8, max=8)
    private String matricule;
    @NotNull
    private String pseudo;
    private String photo;


    public String getMatricule() {
        return this.matricule;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getPhoto() {
        return this.photo;
    }

}