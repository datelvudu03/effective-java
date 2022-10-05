package com.test.effectivejava;

import com.test.effectivejava.pojo.Movie;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\datel\\Desktop\\demo.csv");
        Charset charset = StandardCharsets.UTF_8;
        try{
            List<String> listOfMovies = Files.readAllLines(filePath,charset);

            List<Movie> niceListOfMovie = new ArrayList<>();

            listOfMovies.stream()
                    .map(e -> e.split(","))
                    .filter(e->!e[0].equalsIgnoreCase("movie"))
                    .map(e -> niceListOfMovie.add(new Movie(e[0],BigDecimal.valueOf(Double.parseDouble(e[1])))))
                    .collect(Collectors.toList());

            /////////////////////////////
            System.out.println(getListOfMovies(niceListOfMovie));
            System.out.println(getBestMovie(niceListOfMovie));
            System.out.println(getWorstMovie(niceListOfMovie));
            System.out.println(getAverageRating(niceListOfMovie));

        }catch (Exception e){
            System.out.println(e);
        }

    }
    private static BigDecimal getAverageRating(List<Movie> movieList) {
        return movieList.stream()
                .map(Movie::getRating)
                .reduce(BigDecimal.valueOf(0),BigDecimal::add)
                .divide(BigDecimal.valueOf(movieList.size()),1, RoundingMode.HALF_EVEN);
    }

    public static List<String> getListOfMovies(List<Movie> movieList){
        return movieList.stream()
                .map(Movie::getName)
                .collect(Collectors.toList());
    }
    public static String getBestMovie(List<Movie> movieList){
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .get()
                .getName();
    }
    private static String getWorstMovie(List<Movie> movieList) {
        //Optional get() without isPresent???
        return movieList.stream().min(Comparator.comparing(Movie::getRating))
                .get()
                .getName();
    }
}

