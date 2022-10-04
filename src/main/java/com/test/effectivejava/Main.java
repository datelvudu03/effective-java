package com.test.effectivejava;

import com.test.effectivejava.pojo.Dog;
import com.test.effectivejava.pojo.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Dog> listOfDogs = new ArrayList<>();
        int i = 0;
        while(i < 3){
            double[] ages = {0.1,0.2,0.0};
            Dog dog = Dog.builder()
                    .name("dog "+i).race("race " +i).age(3+i).weight(ages[i]).build();
            listOfDogs.add(dog);
            ++i;
        }
        for (Dog dog: listOfDogs) {
            System.out.println(dog.toString());
        }
        sumaAge(listOfDogs);
    }
    public static void sumaAge(List<Dog> dogList){
        BigDecimal suma = new BigDecimal(0.0) ;
        for (Dog dog: dogList) {
            //BigDecimal weight = new BigDecimal(dog.getWeight());
            BigDecimal weight = BigDecimal.valueOf(dog.getWeight());
            suma = suma.add(weight);
            System.out.println(weight);
        }
        System.out.println("Total weight: "+suma);
    }


}
