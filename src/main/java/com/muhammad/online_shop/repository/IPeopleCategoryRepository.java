package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.shop.PeopleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleCategoryRepository extends JpaRepository<PeopleCategory, Long> {
}
