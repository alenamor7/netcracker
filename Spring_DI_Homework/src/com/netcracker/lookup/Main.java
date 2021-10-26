package com.netcracker.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-lookup.xml");

        Exams exam = (Exams) context.getBean("exam");
        System.out.println(exam.getProg());
        exam.getProg().labs();
        exam.getProg().tests();
    }
}
