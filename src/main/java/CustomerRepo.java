import models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by rodrPMFF on 23/02/2017.
 */
public class CustomerRepo {

    private List<Customer> customers = new ArrayList<Customer>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Optional<Customer> findByBarcode(long barCode){
        return customers.stream().filter(c->c.getCostumerBarcode()==barCode).findFirst();
    }
}
