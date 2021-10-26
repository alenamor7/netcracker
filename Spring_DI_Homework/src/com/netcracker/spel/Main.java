package com.netcracker.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-spel.xml");
        Film myFilm = (Film)context.getBean("myFilm");

        System.out.println(myFilm);
        System.out.println("Title of a film: " + myFilm.getTitle());
        System.out.println("Year: " + myFilm.getYear());
        System.out.println("Director: " + myFilm.getDirector());
    }
}
