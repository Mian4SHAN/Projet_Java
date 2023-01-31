package com.example.projet_Note.model;

public class Movie {

    private String titre;
    private String realisation;
    private Acteur acteur;
    private String date;

    public Movie(String titre, String realisation, Acteur acteur, String date){
        super();
        this.titre = titre;
        this.realisation = realisation;
        this.acteur = acteur;
        this.date = date;
    }
}
