package com.scaler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person p1 = Person.builder().age(25).name("John Doe").build();
        Person p2 = Person.builder().age(25).name("John Doe").build();
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println(p1.equals(p2));   // ?1 true
        System.out.println(p1 == p2);        // ?2 false
    }
}