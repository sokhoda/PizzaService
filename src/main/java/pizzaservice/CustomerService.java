package pizzaservice;

import domain.Address;
import domain.Customer;
import domain.LoyaltyCard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by s_okhoda on 13.10.2016.
 */
public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer find(Long id);

    List<Customer> findByName(String name);

    List<Customer> findByLoyaltyCard(LoyaltyCard loyaltyCard);

    int delete(Customer customer);

    Customer placeNewCustomer(String name, Address address, LoyaltyCard
            loyaltyCard);

    void remove(Customer customer);

    String uploadFile(MultipartFile file);
}
