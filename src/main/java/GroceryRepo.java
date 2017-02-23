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
}
