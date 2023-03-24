package org.example.class1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ComparableDemo {

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);
        System.out.println("List sorting after comparable way");
        System.out.println(list.stream().collect(Collectors.toList()));

        NameComparator nameComparator = new NameComparator();
        Collections.sort(list, nameComparator);
        System.out.println("List sorting after name Comparator way");
        System.out.println(list.stream().collect(Collectors.toList()));

        RatingComparator ratingComparator = new RatingComparator();
        Collections.sort(list, ratingComparator);
        System.out.println("List sorting after rating Comparator way");
        System.out.println(list.stream().collect(Collectors.toList()));


    }
}


class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie o) {
        if (this.year < o.year){
            return -1;
        } else if(this.year == o.year) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

class NameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return (m1.getName().compareTo(m2.getName()));
    }
}

class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return (Double.compare(o1.getRating(), o2.getRating()));
    }
}
