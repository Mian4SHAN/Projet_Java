package com.example.projet_Note.model;

import io.swagger.annotations.ApiModelProperty;
public class Movie {

    @ApiModelProperty(notes = "Movie titre",name="titre",required=true,value="test titre")
    private String titre;

    @ApiModelProperty(notes = "Movie realisation",name="realisation",required=true,value="test realisation")
    private String realisation;

    @ApiModelProperty(notes = "Movie acteur",name="acteur",required=true,value="test acteur")
    private Acteur acteur;

    @ApiModelProperty(notes = "Movie date",name="date",required=true,value="test date")
    private String date;

    public Movie(String titre, String realisation, Acteur acteur, String date){
        super();
        this.titre = titre;
        this.realisation = realisation;
        this.acteur = acteur;
        this.date = date;
    }

    public Movie(){
        super();
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisation() {
        return realisation;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public String getDate() {
        return date;
    }



}
