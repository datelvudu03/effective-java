package com.test.effectivejava.pojo;

import lombok.*;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dog {
        private String name;
        private String race;
        private int age;
        private double weight;
}
