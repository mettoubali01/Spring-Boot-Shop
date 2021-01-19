package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

    void deleteByCalle(String name);
}
