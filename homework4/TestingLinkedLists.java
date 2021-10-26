package homework4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestingLinkedLists {
    private static long startTime = 0;
    private static int size = 10000;

    //testing MyLinkedList in comparison with java LinkedList
    private static LinkedList<String> notMyList = new LinkedList<>();
    private static MyLinkedList<String> myList = new MyLinkedList<>();

    public static void main(String[] args) {
        testAdd();
        testSearchIndex();
        testSearchElement();
        testRemove();
    }

    //testing add elements
    public static void testAdd(){
        startTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            myList.add("new" + i + " ");
        }
        System.out.println("Time of adding element in my List: " + (System.nanoTime() - startTime));
        System.out.println(Arrays.toString(myList.toArray()));

        startTime = System.nanoTime();
        for(int i = 0; i < size; i++){
            notMyList.add("new" + i + " ");
        }
        System.out.println("Time of adding element in NOT my List: " + (System.nanoTime() - startTime));
        System.out.println(Arrays.toString(notMyList.toArray()));
    }

    //testing search an index of element
    public static void testSearchIndex(){
        startTime = System.nanoTime();
        myList.indexOf("new8900");
        System.out.println("Time of searching an Index in my List: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        notMyList.indexOf("new8900");
        System.out.println("Time of searching an Index NOT in my List: " + (System.nanoTime() - startTime));
    }


    //testing search an element by index
    public static void testSearchElement(){
        startTime = System.nanoTime();
        myList.get(9998);
        System.out.println("Time of searching an Element by index in ny List: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        notMyList.get(9998);
        System.out.println("Time of searching an Element by index NOT in ny List: " + (System.nanoTime() - startTime));

    }

    //testing remove element
    public static void testRemove(){
        startTime = System.nanoTime();
        myList.remove(7777);
        System.out.println("Time of removing element in my List: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        notMyList.remove(7777);
        System.out.println("Time of removing element in NOT my List: " + (System.nanoTime() - startTime));
    }

}
