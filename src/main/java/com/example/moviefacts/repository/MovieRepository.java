package com.example.moviefacts.repository;

import com.example.moviefacts.model.Movie;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieRepository {
  ArrayList<Movie> movies = new ArrayList<>();

  public String readFile(){
    try {
      File file = new ClassPathResource("imdb-data.csv").getFile();
      Scanner reader = new Scanner(file);
      int counter = 0;
      while(reader.hasNextLine()){
        if (counter == 0){
          String headline = reader.nextLine();
          counter++;
        } else {
          String line = reader.nextLine();
          String[] wordsOnLine = line.split(";");
          boolean awards = true;
          for(int i = 0; i < wordsOnLine.length; i++){
          if (wordsOnLine[i].equalsIgnoreCase("no")){
          awards = false;
          break;
          }
          }
          movies.add(new Movie(Integer.parseInt(wordsOnLine[0]), Integer.parseInt(wordsOnLine[1]),wordsOnLine[2],
              wordsOnLine[3],Integer.parseInt(wordsOnLine[4]),awards));
        }
      }
    } catch (IOException e){
      System.out.println("Can't read file" + e);
    }
    String movielist = "";

    for (int i = 0; i < movies.size(); i++){
    movielist += movies.get(i) + "<br>";
    }
    return movielist;
  }

  public String get10SortPopularity(){
    String tenPopularitySorted = "";
    ArrayList<Movie> tenRandomMovies = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < 10; i++){
      tenRandomMovies.add(movies.get(rand.nextInt(movies.size())));
    }

    Collections.sort(tenRandomMovies);

    for (int i = 0; i < 10; i++){
      tenPopularitySorted += tenRandomMovies.get(i);
    }
  return "<p style = font-family:georgia,garamond,serif;font-size:32px;font-style:italic;>" + tenPopularitySorted + "</p>";

  }

  public String getRandom(){
    Random rand = new Random();
    return movies.get(rand.nextInt(movies.size())).getTitle();
  }

  public ArrayList<Movie> getMovies() {
    return movies;
  }
}
