package com.example.projet_Note.controller;

import com.example.projet_Note.model.Acteur;
import com.example.projet_Note.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    List<Acteur> listActeurs = new ArrayList<Acteur>();
    List<Movie> listMovies = new ArrayList<Movie>();
    {
        listActeurs.add(new Acteur("Craig", "Daniel ", "1968", new Movie("Skyfall", "Sam Mendes", new Acteur(), "2012")));
        listActeurs.add(new Acteur("Bale", "Christian", "2022", new Movie( "The Dark Knight", "Christopher Nolan", new Acteur(), "2008")));
        listActeurs.add(new Acteur("Depp", "Johnny", "1963", new Movie("Pirates des Caraïbes", "Gore Verbinski", new Acteur(), "2003")));
        listActeurs.add(new Acteur("Pitt", "Brad", "1963", new Movie("Fight Club", "David Fincher", new Acteur(), "1999")));
        listMovies.add(new Movie("Skyfall", "Sam Mendes", new Acteur(), "2012"));
        listMovies.add(new Movie("The Dark Knight", "Christopher Nolan", new Acteur(), "2008"));
        listMovies.add(new Movie("Pirates des Caraïbes", "Gore Verbinski", new Acteur(), "2003"));
        listMovies.add(new Movie("Fight Club", "David Fincher", new Acteur(), "1999"));
    } 
    
    //Recupération de la liste des acteurs
    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
       return listActeurs;
    }

    @RequestMapping(value = "/getActeurs/{name}")
    public Acteur getActeur(@PathVariable(value = "name") String name){
        return listActeurs.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    //Recupération de la liste de acteurs par le films
   @RequestMapping(value = "/getActeurs/{film}")
    public List<Acteur> getActeursByFilm(@PathVariable(value = "film") String film) {
        return listActeurs.stream().filter(x -> x.getFilmographie().getTitre().equalsIgnoreCase(film)).collect(Collectors.toList());
    }

    //Recupération de la liste des films
    @RequestMapping(value = "/getMovies")
    public List<Movie> getMovies() {
        return listMovies;
    }

    //Recupération de la liste de films par le titre
    @RequestMapping(value = "/getMovies/{titre}")
    public Movie getMovie(@PathVariable(value = "titre") String titre) {
        return listMovies.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }

    //Recupération des films selon l'année de sortie
    @RequestMapping(value = "/getMovies/{annee}")
    public List<Movie> getMoviesByYear(@PathVariable(value = "annee") String annee) {
        return listMovies.stream().filter(x -> x.getDate().equalsIgnoreCase(annee)).collect(Collectors.toList());
    }

       
}
