package com.example.projet_Note.model;

public class Acteur {

    private String nom;
    private String prenom;
    private String date_naissance;
    private Movie filmographie;

    public Acteur(String nom, String prenom, String date,Movie filmographie){
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date;
        this.filmographie = filmographie;
    }

    public String getName() {
        return nom;
    }

    public String getPrenom() { return prenom;}


}
