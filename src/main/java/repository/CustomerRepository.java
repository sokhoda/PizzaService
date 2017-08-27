package repository;

import domain.Customer;
import domain.LoyaltyCard;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer find(Long id);

    List<Customer> findByName(String name);

    List<Customer> findByLoyaltyCard(LoyaltyCard loyaltyCard);

    Customer save(Customer customer);

    int delete(Customer customer);

    void remove(Customer customer);
}
