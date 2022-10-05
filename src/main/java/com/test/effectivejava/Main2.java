package com.test.effectivejava;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {

        Path filePath = Paths.get("C:\\Users\\datel\\Desktop\\demo.csv");
        Charset charset = StandardCharsets.UTF_8;
        String bestFilm = null;
        String worstFilm = null;
        BigDecimal sumaRating = BigDecimal.ZERO;
        BigDecimal bestRating = null;
        BigDecimal worstRating = null;
        BigDecimal avrRating;

        Map<String,BigDecimal> filmList = new HashMap<>();
        try{
            List<String> listOfMovies = Files.readAllLines(filePath,charset);
            int movieCount = 0;
            for (String line: listOfMovies) {
                String[] splitLine = line.split(",");

                //System.out.println(line);
                if (splitLine[0].equalsIgnoreCase("movie")){
                    continue;
                }
                if (movieCount == 0){
                    bestRating = BigDecimal.valueOf(Double.parseDouble(splitLine[1]));
                    worstRating = BigDecimal.valueOf(Double.parseDouble(splitLine[1]));
                }

                movieCount++;
                filmList.put(splitLine[0], BigDecimal.valueOf(Double.parseDouble(splitLine[1])));
                bestRating = bestRating.max(BigDecimal.valueOf(Double.parseDouble(splitLine[1])));
                worstRating = worstRating.min(BigDecimal.valueOf(Double.parseDouble(splitLine[1])));
                BigDecimal rating = new BigDecimal(splitLine[1]);
                sumaRating = sumaRating.add(rating);

            }
            avrRating = sumaRating.divide(BigDecimal.valueOf(movieCount),1,RoundingMode.HALF_EVEN);

            for (Map.Entry<String, BigDecimal> set: filmList.entrySet()) {
                System.out.println(set.getKey());
                if (set.getValue().equals(bestRating)){
                    bestFilm = set.getKey();
                }
                if (set.getValue().equals(worstRating)){
                    worstFilm = set.getKey();
                }
            }
            //System.out.println(filmList);
            System.out.println("The average rating is: " + avrRating);
            System.out.println("Best movie: " + bestFilm);
            System.out.println("Worst movie: " + worstFilm);
        }catch (IOException e){
            System.out.println(e);
        }

    }

}
