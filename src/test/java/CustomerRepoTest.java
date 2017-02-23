import models.Customer;
import models.LoyaltyCard;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wouterba on 23/02/2017.
 */
public class CustomerRepoTest {
    private CustomerRepo repo;

    @Before
    public void setUp(){
        repo = new CustomerRepo();
    }
    @Test
    public void addCustomer() throws Exception {
        Customer customer = new Customer(1, "Wouter", new LoyaltyCard(1, 0));
        repo.addCustomer(customer);
        Assertions.assertThat(repo.getCustomers().contains(customer)).isTrue();
    }

    @Test
    public void findByBarcode_returnsExpectedCustomer() throws Exception {
        Customer customer = new Customer(1, "Wouter", new LoyaltyCard(1, 0));
        repo.addCustomer(customer);
        Assertions.assertThat(repo.findByBarcode(1).get()).isEqualTo(customer);
    }
}