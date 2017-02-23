import models.Grocery;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by wouterba on 23/02/2017.
 */
public class GroceryRepoTest {
    private GroceryRepo repo;

    @Before
    public void setUp(){
        repo = new GroceryRepo();
    }

    @Test
    public void AddedGroceryToRepo_SearchByDay_ContainsAddedGrocery(){
        LocalDate date = LocalDate.of(2017,2,23);
        Grocery grocery = new Grocery("Tomato", date);

        repo.addGrocery(grocery);
        Assertions.assertThat(repo.findGroceriesByDate(date).contains(grocery)).isTrue();
    }

    @Test
    public void AddedGroceryToRepo_SearchByOtherDay_returnsEmptyList(){
        LocalDate date = LocalDate.of(2017,2,23);
        Grocery grocery = new Grocery("Tomato", date);

        repo.addGrocery(grocery);
        Assertions.assertThat(repo.findGroceriesByDate(date.plusDays(3)).equals(Collections.emptyList())).isTrue();
    }
}