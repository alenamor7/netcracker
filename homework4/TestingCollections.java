package homework4;
import java.util.*;

public class TestingCollections {
    private static long startTime = 0;
    private static int size = 10000;

    public static void main(String[] args) {
        testLists();
        testSets();
        testMaps();
    }
    

    //test arrayList and LinkedList
    public static void testLists() {
        ArrayList<Integer> aList = new ArrayList<>();
        LinkedList<Integer> lList = new LinkedList<>();

        //test adding
        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            aList.add(i);
        }
        System.out.println("Time of adding elements in ArrayList: " + (System.nanoTime() - startTime));
        long startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            lList.add(i);
        }
        System.out.println("Time of adding elements in LinkedList: " + (System.nanoTime() - startTime));

        //test searching an element
        System.out.println();
        startTime = System.nanoTime();
        aList.add(5000, 4);
        System.out.println("Time of adding ONE element by index in ArrayList: " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        lList.add(5000, 4);
        System.out.println("Time of adding ONE elements by index in LinkedList: " + (System.nanoTime() - startTime));

        //test searching an element
        System.out.println();
        startTime = System.nanoTime();
        aList.get(7777);
        System.out.println("Time of getting element from ArrayList: " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        lList.get(7777);
        System.out.println("Time of getting element from LinkedList: " + (System.nanoTime() - startTime));

        //test removing an element
        System.out.println();
        startTime = System.nanoTime();
        aList.remove(5555);
        System.out.println("Time of removing elements from ArrayList: " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        lList.remove(5555);
        System.out.println("Time of removing elements from LinkedList: " + (System.nanoTime() - startTime));
        System.out.println();
    }


    //testing HashSet, LinkedHashSet, TreeSet
    public static void testSets() {

        HashSet<String> hSet = new HashSet<>();
        LinkedHashSet<String> lSet = new LinkedHashSet<>();
        TreeSet<String> tSet = new TreeSet<>();

        //test add elements
        startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            hSet.add("set" + i);
        }
        System.out.println("Time of adding elements in HashSet: " + (System.nanoTime() - startTime));

        long startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            lSet.add("set" + i);
        }
        System.out.println("Time of adding elements in LinkedHashSet: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            tSet.add("set" + i);
        }
        System.out.println("Time of adding elements in TreeSet: " + (System.nanoTime() - startTime));
        System.out.println();


        //test removing elements
        startTime = System.nanoTime();
        hSet.remove("set7777");
        System.out.println("Time of removing element from HashSet: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        lSet.remove("set7777");
        System.out.println("Time of removing element from LinkedHashSet: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        tSet.remove("set7777");
        System.out.println("Time of removing element from TreeSet: " + (System.nanoTime() - startTime));
        System.out.println();
    }

    //testing HashMap, LinkedHashMap, TreeMap
    public static void testMaps() {
        HashMap<String, Integer> hMap = new HashMap<>();
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        TreeMap<String, Integer> tMap = new TreeMap<>();

        //test add elements
        startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            hMap.put("map" + i, i);
        }
        System.out.println("Time of adding elements in HashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            lMap.put("map" + i, i);
        }
        System.out.println("Time of adding elements in LinkedHashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for( int i = 0; i < 10; i++) {
            tMap.put("map" + i, i);
        }
        System.out.println("Time of adding elements in TreeMap: " + (System.nanoTime() - startTime));
        System.out.println();


        //test removing element from Map
        startTime = System.nanoTime();
        hMap.remove("map7777");
        System.out.println("Time of removing element from HashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        lMap.remove("map7777");
        System.out.println("Time of removing element from LinkedHashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        tMap.remove("map7777");
        System.out.println("Time of removing element from TreeMap: " + (System.nanoTime() - startTime));
        System.out.println();


        //test getting element from Map
        startTime = System.nanoTime();
        hMap.get("map7777");
        System.out.println("Time of getting element from HashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        lMap.get("map7777");
        System.out.println("Time of getting element from LinkedHashMap: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        tMap.get("map7777");
        System.out.println("Time of getting element from TreeMap: " + (System.nanoTime() - startTime));
        System.out.println();
    }

    /*
        - обычное добавление элементов в конец ArrayList происходит быстрее, чем в конец Linked List,
        так как в ArrayList добавление происходит за константное время.

        -добавление элемента в середину списка примерно одинаковое.
        С увеличением индекса элемента время добавления элемента увеличивается у LinkedList
        (потому что приходится последовательно проходить больше элементов) и уменьшается у ArrayList

        - получить/удалить элемент по индексу в ArrayList гораздо быстрее,
        так как этот лист основан на массиве и доступ происходит по индексу в массиве.
        В LinkedList эта операция происходит медленнее, так как сначала происходит
         последовательный поиск элемент по листу, а потом уже получение/удаление значения

         -отсюда следует, что Linked List проигрывает по времени почти во всех операциях,
         однако его предпочтительно использовать для добавления элементов в середину листа.

         - Set - это множество неповторяющихся элементов.
         HashSet работает быстрее(иногда гораздо быстрее),
         чем TreeSet(набор упорядоченных элементов), поэтому предпочтительно использовать HashSet,
          если работаем с неупорядоченными элементами

          - LinkedHashSet представляет собой упорядоченное по порядку вставки множество,
           поэтому оно более быстродейственное в операциях, связанных c порядком итерации

           -Map представляет собой "словарь" с набором значений ключ-значение.
           HashMap работает также быстрее, чем TreeMap, если не требуется упорядочить элементы

           -LinkedHashMap также более быстродейственная коллекция в операциях,связанных с порядком итерации
         */
}
