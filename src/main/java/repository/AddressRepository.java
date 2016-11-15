package repository;

import domain.Address;

import java.util.List;

public interface AddressRepository {

    Address find(Long id);

    List<Address> findAll(String orderBy);

    List<Address> findByCityName(String city);

    Address save(Address address);

}
