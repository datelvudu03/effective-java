package com.test.effectivejava;

import com.test.effectivejava.pojo.Dog;
import com.test.effectivejava.pojo.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Dog> listOfDogs = new ArrayList<>();
        int i = 1;
        while(i < 4){
            Dog dog = Dog.builder()
                    .name("dog "+i).race("race " +i).age(3+i).build();
            listOfDogs.add(dog);
            ++i;
        }
        for (Dog dog: listOfDogs) {
            System.out.println(dog.getName()+" " + dog.getRace() + " " + dog.getAge());
        }
    }


}
