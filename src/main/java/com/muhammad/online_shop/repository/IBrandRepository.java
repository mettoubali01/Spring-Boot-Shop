package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.shop.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

    Brand findBrandByName(String name);

}
