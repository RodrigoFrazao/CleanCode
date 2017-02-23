package repos;

import models.Grocery;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by wouterba on 23/02/2017.
 */
public class GroceryRepo {
    private Map<LocalDate, List<Grocery>> groceries;

    public GroceryRepo() {
        groceries = new TreeMap<>();
    }

    public void addGrocery(Grocery grocery) {
        addDateToMapOfGroceriesIfAbsent(grocery);
        addGroceryToMap(grocery);
    }

    private void addDateToMapOfGroceriesIfAbsent(Grocery grocery) {
        if (!groceries.containsKey(grocery.getDate())){
            groceries.put(grocery.getDate(), new ArrayList<>());
        }
    }

    private void addGroceryToMap(Grocery grocery) {
        groceries.get(grocery.getDate()).add(grocery);
    }

    public List<Grocery> findGroceriesByDate(LocalDate date) {
        return getListOfGroceriesForDate(date);
    }

    private List<Grocery> getListOfGroceriesForDate(LocalDate date) {
        List<Grocery> groceryList = groceries.get(date);
        if (!groceries.containsKey(date)){
            groceryList = Collections.emptyList();
        }
        return groceryList;
    }

    public  Map<LocalDate,List<Grocery>> getAll(){
        return groceries;
    }
    public Grocery getMostBoughtGrocery(){
        Map<Grocery,Integer> groceryAmountMap;
        groceryAmountMap = createGroceryAmountMap();

        int index =findHighestValueIndex(groceryAmountMap);
        Object[] groceries = groceryAmountMap.keySet().toArray();
        return (Grocery) groceries[index];
    }

    private int findHighestValueIndex(Map<Grocery,Integer> groceryAmountMap) {
        int i =0;
        int index=0;
        int max =0;
        for(Integer j : groceryAmountMap.values()){
           if(j.intValue()>max){
               max = j.intValue();
               index = i;
           }
           i++;
       }
       return index;

    }

    private Map<Grocery,Integer> createGroceryAmountMap() {
        Map<Grocery,Integer> groceryAmountMap = new HashMap<>();
        for (LocalDate date:groceries.keySet()) {
            for (List<Grocery> groceryList:groceries.values()) {
                for (Grocery grocery : groceryList ) {
                    if(groceryAmountMap.keySet().contains(grocery)){
                        Integer i = groceryAmountMap.get(grocery);
                        i=i.intValue()+1;
                        groceryAmountMap.put(grocery,i);
                    }
                    groceryAmountMap.put(grocery,1);
                }
            }
        }
        return  groceryAmountMap;
    }


}
