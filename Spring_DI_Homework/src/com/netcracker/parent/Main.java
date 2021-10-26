package com.netcracker.parent;

import com.netcracker.injection.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-parent.xml");

        ParentBook sherlock = (ParentBook)context.getBean("Parent");
        ChildBook baskervillesHound = (ChildBook)context.getBean("Child");

        System.out.println(sherlock);
        System.out.println(baskervillesHound);
    }
}
