package com.netcracker.injection;

import com.netcracker.collections.LibraryList;
import com.netcracker.collections.LibraryMap;
import com.netcracker.collections.LibrarySet;
import com.netcracker.genres.Horror;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        InjectionCI();  //test primitive and collections CI
        InjectionSI();  //test primitive and collections SI
    }

    static void InjectionCI(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-CI.xml");

        Book gameOfThrones = (Book)context.getBean("GameOfThrones");
        Book shining = (Book)context.getBean("Shining");
        Book sapiens = (Book)context.getBean("Sapiens");

        System.out.println(gameOfThrones);
        System.out.println(shining);
        System.out.println(sapiens);

        System.out.println();
        System.out.println(gameOfThrones.getTitle() + "'s genre is " + gameOfThrones.getGenre());
        System.out.println(shining.getTitle() + "'s genre is " + shining.getGenre());
        System.out.println(sapiens.getTitle() + "'s genre is " + sapiens.getGenre());

        gameOfThrones.getGenre().printGenre();
        shining.getGenre().printGenre();
        sapiens.getGenre().printGenre();

        collectionsTesting(context);
    }

    static void InjectionSI(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-SI.xml");

        Book harryPotter = (Book)context.getBean("HarryPotter");
        Book it = (Book)context.getBean("It");
        Book selfishGene = (Book)context. getBean("TheSelfishGene");

        System.out.println(harryPotter);
        System.out.println(it);
        System.out.println(selfishGene);

        System.out.println();
        System.out.println(harryPotter.getTitle() + "'s genre is " + harryPotter.getGenre());
        System.out.println(it.getTitle() + "'s genre is " + it.getGenre());
        System.out.println(selfishGene.getTitle() + "'s genre is " + selfishGene.getGenre());

        harryPotter.getGenre().printGenre();
        it.getGenre().printGenre();
        selfishGene.getGenre().printGenre();
        collectionsTesting(context);

    }

    static void collectionsTesting(ApplicationContext context){
        System.out.println();
        LibraryList libList = (LibraryList)context.getBean("libraryList");
        LibraryMap libMap = (LibraryMap)context.getBean("libraryMap");
        LibrarySet libSet = (LibrarySet)context.getBean("librarySet");

        System.out.println("List's size is " + libList.getLibrary().size());
        System.out.println(libList.toString());
        System.out.println("After addition a new book \n" + libList.toString());
        System.out.println("Map's size is " + libMap.getLibraryMap().size());
        System.out.println(libMap.toString());
        System.out.println("Set's size is " + libSet.getLibrarySet().size());
        System.out.println(libSet.toString());
    }


}
