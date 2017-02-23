import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrPMFF on 23/02/2017.
 */
public class Service {

    List<Costumer> costumers = new ArrayList<Costumer>();

    public void addCostumer(Costumer costumer){
        costumers.add(costumer);
    }

    public Costumer findByBarcode(long barCode){

        for (Costumer costumer: costumers) {
           if (costumer.getCostumerBarcode() == barCode){
               return costumer;
           }
        }
    }
}
