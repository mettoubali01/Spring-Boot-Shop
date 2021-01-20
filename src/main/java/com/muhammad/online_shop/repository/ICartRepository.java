package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.customer.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
