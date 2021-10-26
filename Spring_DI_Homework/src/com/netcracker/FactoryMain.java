package com.netcracker;

import com.netcracker.genres.Fantasy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-factory.xml");
        Fantasy fantasy = (Fantasy)context.getBean("fantasy");
        fantasy.printGenre();
    }
}
