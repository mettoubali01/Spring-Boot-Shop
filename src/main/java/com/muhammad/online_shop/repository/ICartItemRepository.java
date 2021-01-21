package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.customer.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long> {

    boolean existsByProductId(long productId);
    @Query("select ci from CartItem ci where ci.product in (select p from Product p where p.id =?1)")
    CartItem findByProductId(long productId);
}
