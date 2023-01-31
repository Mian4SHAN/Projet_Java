package com.example.projet_Note.controller;

import com.example.projet_Note.model.Acteur;
import com.example.projet_Note.model.Movie;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Controller")
@RestController
public class Controller {

    List<Acteur> listActeurs = new ArrayList<Acteur>();
    List<Movie> listMovies = new ArrayList<Movie>();
    {
        listActeurs.add(new Acteur("Craig", "Daniel ", "1968", new Movie("Skyfall", "Sam Mendes", new Acteur(), "2012")));
        listActeurs.add(new Acteur("Bale", "Christian", "1974", new Movie( "The Dark Knight", "Christopher Nolan", new Acteur(), "2008")));
        listActeurs.add(new Acteur("Javier", "Bardem ", "1969", new Movie("Skyfall", "Sam Mendes", new Acteur(), "2012")));
        listActeurs.add(new Acteur("Depp", "Johnny", "1963", new Movie("Pirates des Caraïbes", "Gore Verbinski", new Acteur(), "2003")));
        listActeurs.add(new Acteur("Pitt", "Brad", "1963", new Movie("Fight Club", "David Fincher", new Acteur(), "1999")));
        listMovies.add(new Movie("Skyfall", "Sam Mendes", new Acteur(), "2012"));
        listMovies.add(new Movie("The Dark Knight", "Christopher Nolan", new Acteur(), "2008"));
        listMovies.add(new Movie("Pirates des Caraïbes", "Gore Verbinski", new Acteur(), "2003"));
        listMovies.add(new Movie("Fight Club", "David Fincher", new Acteur(), "1999"));
        listMovies.add(new Movie("Highlander", "Russell Mulcahy", new Acteur(), "1986"));
        listMovies.add(new Movie("2001: A Space Odyssey", "Stanley Kubrick", new Acteur(), "1968"));
    } 

    //Déclaration des erreurs 
    @ApiOperation(value = "Get list of Students in the System ", response = Iterable.class, tags = "getStudents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    
    //Recupération de la liste des acteurs
    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
       return listActeurs;
    }

    //Recupération de la liste de acteurs par le nom
    @ApiOperation(value = "Liste des acteurs par nom ", response = Acteur.class, tags = "getActeurParNom")
    @RequestMapping(value = "/getActeurParNom/{name}")
    public Acteur getActeur(@PathVariable(value = "name") String name){
        return listActeurs.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    //Recupération de la liste de acteurs par le films
    @ApiOperation(value = "Liste des acteurs par films ", response = Iterable.class, tags = "getActeurParFilms")
    @RequestMapping(value = "/getActeurParFilms/{film}")
    public List<Acteur> getActeursByFilm(@PathVariable(value = "film") String film) {
        return listActeurs.stream().filter(x -> x.getFilmographie().getTitre().equalsIgnoreCase(film)).collect(Collectors.toList());
    }

    //Recupération de la liste des films
    @RequestMapping(value = "/getMovies")
    public List<Movie> getMovies() {
        return listMovies;
    }

    //Recupération de la liste de films par le titre
    @ApiOperation(value = "Liste des films par titre ", response = Movie.class, tags = "getMovieParTitre")
    @RequestMapping(value = "/getMovieParTitre/{titre}")
    public Movie getMovie(@PathVariable(value = "titre") String titre) {
        return listMovies.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }

    //Recupération des films selon l'année de sortie
    @ApiOperation(value = "Liste des films par année ", response = Iterable.class, tags = "getMoviesParAnnee")
    @RequestMapping(value = "/getMoviesParAnnee/{annee}")
    public List<Movie> getMoviesByYear(@PathVariable(value = "annee") String annee) {
        return listMovies.stream().filter(x -> x.getDate().equalsIgnoreCase(annee)).collect(Collectors.toList());
    }

       
}
