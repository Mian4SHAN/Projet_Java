package com.example.projet_Note.model;

import io.swagger.annotations.ApiModelProperty;
public class Acteur {

    @ApiModelProperty(notes = "Acteur nom",name="nom",required=true,value="test nom")
    private String nom;

    @ApiModelProperty(notes = "Acteur prenom",name="prenom",required=true,value="test prenom")
    private String prenom;

    @ApiModelProperty(notes = "Acteur date de naissance",name="date_naissance",required=true,value="test date de naissance")
    private String date_naissance;

    @ApiModelProperty(notes = "Acteur filmographie",name="filmographie",required=true,value="test filmographie")
    private Movie filmographie;

    public Acteur(String nom, String prenom, String date, Movie filmographie){
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date;
        this.filmographie = filmographie;
    }

    public Acteur(){
        super();
    }

    public String getName() {
        return nom;
    }

    public String getPrenom() { return prenom;}

    public Movie getFilmographie() { return filmographie; }

    public String getDate_naissance() { return date_naissance; }

}
