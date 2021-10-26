package homework3.task6;

public class EnumTesting {
    public static void main(String[] args) {
        RussianCities city = RussianCities.MOSCOW;

        //switch-case
        long startTime1 = System.nanoTime();
        switch(city){
            case MOSCOW:
            case SAINTPETERSBURG:
            case KAZAN:
            case KALININGRAD:
            case NIZHNYNOVGOROD:
                System.out.println("Welcome to " + city);
        }
        long estimatedTime1 = System.nanoTime() - startTime1;


        //if-else
        long startTime2 = System.nanoTime();
        if(city == RussianCities.MOSCOW){
            System.out.println("Welcome to Moscow");
        }
        else if(city == RussianCities.SAINTPETERSBURG){
            System.out.println("Welcome to Saint Petersburg");
        }
        else if(city == RussianCities.KAZAN){
            System.out.println("Welcome to Kazan");
        }
        else if(city == RussianCities.KALININGRAD) {
            System.out.println("Welcome to Kalinigrad");
        }
        else if(city == RussianCities.NIZHNYNOVGOROD){
            System.out.println("Welcome to Nizhny Novgorod");
        }
//        or
//        for(RussianCities c : RussianCities.values()){
//            if(city.equals(c)){
//                System.out.println("Welcome to " + city);
//            }
//
//        }
        long estimatedTime2 = System.nanoTime() - startTime2;

        //printing results
        System.out.println("Time of executing switch-case: " + estimatedTime1);
        System.out.println("Time of executing if-else: " + estimatedTime2);
        //if-else is faster
    }
}
