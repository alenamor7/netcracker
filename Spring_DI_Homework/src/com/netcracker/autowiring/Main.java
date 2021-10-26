package com.netcracker.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        byType();
        byName();
        constructorWiring();
        noWiring();
    }

    static void byType() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-autowiring-type.xml");

        Dictionary russian = (Dictionary)context.getBean("dictionary");
        System.out.println(russian.getSpeakingPeople() + " people in the world say ");
        russian.getLanguage().sayHi();
        System.out.println("and ");
        russian.getLanguage().sayBye();
    }

    static void byName() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-autowiring-name.xml");
        Dictionary russian= (Dictionary)context.getBean("dictionary");
        russian.getLanguage().sayHi();
        russian.getLanguage().sayBye();
    }

    static void constructorWiring(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-autowiring-constructor.xml");
        Dictionary german = (Dictionary)context.getBean("dictionary");
        german.getLanguage().sayHi();
        german.getLanguage().sayBye();
    }

    static void noWiring(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-autowiring-no.xml");
        Dictionary german = (Dictionary)context.getBean("dictionary1");
        Dictionary russian = (Dictionary)context.getBean("dictionary2");
        System.out.println("German: ");
        german.getLanguage().sayHi();
        german.getLanguage().sayBye();
        System.out.println("Russian: ");
        russian.getLanguage().sayHi();
        russian.getLanguage().sayBye();
    }

}
