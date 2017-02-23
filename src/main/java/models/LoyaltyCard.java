package models;

/**
 * Created by rodrPMFF on 23/02/2017.
 */
public class LoyaltyCard {

    private long barcode;
    private int bonusPoints;

    public LoyaltyCard(long barcode, int bonusPoints) {
        this.barcode = barcode;
        this.bonusPoints = bonusPoints;
    }

    public long getBarcode() {
        return barcode;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }
}
