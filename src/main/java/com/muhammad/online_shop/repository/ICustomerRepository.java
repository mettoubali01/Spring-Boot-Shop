package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    void deleteByNif(String nif);
    Customer findByNif(String nif);
}
