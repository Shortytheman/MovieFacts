package com.example.moviefacts.model;

public class Movie implements Comparable<Movie>{
  int year;
  int length;
  String title;
  String subject;
  int popularity;
  boolean awards;

  public Movie(int year, int length, String title, String subject, int popularity, boolean awards){
  this.year = year;
  this.length = length;
  this.title = title;
  this.subject = subject;
  this.popularity = popularity;
  this.awards = awards;
  }

  public String getTitle() {
    return title;
  }

  public String toString(){
    return "Year: " + year + " Length: " + length + " title: " + title + " Subject: " + subject + " Popularity: "
        + popularity + " Awards: " + awards + "<br>";
  }

  @Override
  public int compareTo(Movie o) {
    return this.popularity - o.popularity;
  }
}
