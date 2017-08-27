package repository;

import domain.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("addressRepository")
public class JPAAddressRepo implements AddressRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Address> findAll(String orderBy) {
//        Query query = em.createNativeQuery("SELECT * FROM ADDRESS ORDER BY " +
//                orderBy, Address.class);
        Query query = em.createQuery("SELECT a FROM Address a ORDER BY " +
                orderBy, Address.class);
        return query.getResultList();
    }

    @Override
    public Address find(Long id) {
        return em.find(Address.class, id);
    }

    @Override
    public List<Address> findByCityName(String city) {
        TypedQuery<Address> query = em.createNamedQuery("Address" +
                ".findByCityName", Address.class);
        return query.setParameter("city", city).getResultList();
    }

    @Override
    @Transactional
    public void remove(Address address) {
        Address mergedAddress = em.merge(address);
        em.remove(mergedAddress);
    }

    @Override
    @Transactional
    public Address save(Address address) {
        return em.merge(address);
    }

}
