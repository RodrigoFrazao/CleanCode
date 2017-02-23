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
}
