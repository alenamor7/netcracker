package homework4;

import java.util.Arrays;

public class MainClass {


    public static void main(String[] args) {

        //testing MyLinkedList
        MyLinkedList<String> list1 = new MyLinkedList<>();

        for(int i = 0; i < 10; i++) {
            list1.add("new" + i + " ");
        }
        System.out.println("Current size of list: " + list1.size());
        System.out.println(list1.toString());

        System.out.println();
        list1.add(5, "new10");
        System.out.println("Current size of list: " + list1.size());
        System.out.println(list1.toString());
        list1.add(11, "new11");
        System.out.println("Current size of list: " + list1.size());
        System.out.println(list1.toString());

        System.out.println(list1.get(6) + " is placed by index 6");
        System.out.println(list1.indexOf("new11") + " is an index of element new11");


        System.out.println();
        System.out.println(list1.remove(4) + " was removed");
        System.out.println(list1.toString());

        System.out.println();
        System.out.println(list1.set(2, "new12") + "is placed instead of element in 2nd index");
        System.out.println(list1.toString());

        System.out.println("List as an array: " + Arrays.toString(list1.toArray()));

        list1.clear();
        System.out.println();
        System.out.println("Cleared list: " + list1.toString());
        System.out.println(list1.size());
        System.out.println();
    }

}
