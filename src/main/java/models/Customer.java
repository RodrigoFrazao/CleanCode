package models;

/**
 * Created by rodrPMFF on 23/02/2017.
 */
public class Customer {

    private long id;
    private String name;
    private LoyaltyCard personalCard;

    public Customer(long id, String name, LoyaltyCard personalCard) {
        this.id = id;
        this.name = name;
        this.personalCard = personalCard;
    }

    public void addCard(long barcode, int bonusPoints){
        this.personalCard = new LoyaltyCard(barcode, bonusPoints);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LoyaltyCard getPersonalCard() {
        return personalCard;
    }

    public long getCostumerBarcode(){

        return personalCard.getBarcode();
    }
}
