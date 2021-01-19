package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.domain.shop.PeopleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesCategoryRepository extends JpaRepository<ClothesCategory, Long> {

    @Query("select cc from ClothesCategory cc where cc.peopleCategory in (select pc from PeopleCategory pc where pc.name =?1)")
    List<ClothesCategory> findClothesCategoryByPeopleCategory(String peopleCat);
    @Query("select cc from ClothesCategory cc where cc.name = ?1 and cc.peopleCategory in (select pc from PeopleCategory pc where pc.name =?2)")
    List<ClothesCategory> findClothesCategoryByNameAndPeopleCategory(String name, String peopleCat);
    List<ClothesCategory> findByName(String name);
    @Query("select cc from ClothesCategory cc where cc.brand in (select b from Brand b where b.name = ?1)")
    List<ClothesCategory> findByBrand(String brand);
    @Query("select cc from ClothesCategory cc where cc.name =?1 and cc.brand in (select b from Brand b where b.name = ?2)")
    List<ClothesCategory> findByNameAndBrand(String name, String brand);
}
