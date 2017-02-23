package models;

import java.time.LocalDate;

/**
 * Created by rodrPMFF on 23/02/2017.
 */
public class Grocery {
    private LocalDate dateDelivered;
    private String description;



    public Grocery(String description, LocalDate date) {
        this.description = description;
        this.dateDelivered = date;
    }

    public LocalDate getDate() {
        return dateDelivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grocery grocery = (Grocery) o;

        return description.equals(grocery.description);
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
