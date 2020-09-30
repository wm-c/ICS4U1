package datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListProject {
    
    public static ArrayList<General> generalLists = new ArrayList<>();

    public static void main(String[] args) {
        new ArrayListProject();
    }

    public ArrayListProject(){
        addGenerals();
        printGenerals();
        filterDead();
        printGenerals();
    }

    static class General{

        String name;
        int yearsOfService;
        String country;
        Boolean isAlive;

        public General(String name, int yearsOfService, String country, Boolean isAlive){
            this.name = name;
            this.yearsOfService = yearsOfService;
            this.country = country;
            this.isAlive = isAlive;
        }

    }


    public static void addGenerals(){
        generalLists.add(new General("Sun Tzu", 17, "China", false));
        generalLists.add(new General("Douglas MacArthur", 61, "United States", false));
        generalLists.add(new General("Ulysses Grant", 24, "United States", false));
        generalLists.add(new General("Arthur Currie", 23, "Canada", false));
        generalLists.add(new General("Gervais Carpentier", 33, "Canada", true));
    }

    public static void printGenerals() {
        System.out.printf("%-20s Years of Service %-15s Alive %n", "General", "Country");
        for (General general : generalLists) {
            System.out.printf("%-20s %-16d %-15s %b %n", general.name, general.yearsOfService, general.country, general.isAlive);
        }

        System.out.println();
        
    }

    public static void filterDead(){
        Iterator<General> generalIterator = generalLists.iterator();
        while(generalIterator.hasNext()){
            General tempGeneral = generalIterator.next();
            if(!tempGeneral.isAlive){
                generalIterator.remove();
            }
        }
        
    }



}
