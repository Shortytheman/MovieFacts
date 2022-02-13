package com.example.moviefacts.controller;

import com.example.moviefacts.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFactsController {

  @GetMapping("/")
  public String index(){
    return "yoyo";
  }

  @GetMapping("/findall")
  public String findall(){
    MovieRepository movieRepository = new MovieRepository();
    return movieRepository.readFile();
  }

  @GetMapping("/getfirst")
  public String getfirst(){
    MovieRepository movieRepository = new MovieRepository();
    movieRepository.readFile();
    return movieRepository.getMovies().get(0).getTitle();
  }

  @GetMapping("/getrandom")
  public String getrandom(){
    MovieRepository movieRepository = new MovieRepository();
    movieRepository.readFile();
    return movieRepository.getRandom();
  }

  @GetMapping("/get10sortpopularity")
  public String get10sortpopularity(){
    MovieRepository movieRepository = new MovieRepository();
    movieRepository.readFile();
    return movieRepository.get10SortPopularity();
  }

}
