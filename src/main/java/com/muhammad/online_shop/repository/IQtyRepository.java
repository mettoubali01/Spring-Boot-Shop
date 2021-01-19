package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.shop.Product;
import com.muhammad.online_shop.domain.shop.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQtyRepository extends JpaRepository<Quantity, Long> {
}