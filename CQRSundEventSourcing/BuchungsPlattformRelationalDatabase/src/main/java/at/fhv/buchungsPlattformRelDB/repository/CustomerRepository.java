package at.fhv.buchungsPlattformRelDB.repository;

import at.fhv.buchungsPlattformRelDB.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    boolean existsByUsername(String username);
    Customer findByUsername(String username);
}
