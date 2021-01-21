package com.muhammad.online_shop.repository;

import com.muhammad.online_shop.domain.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p, ClothesCategory cc where p.clothesCategory in (select cc from ClothesCategory cc where cc.name =?1)")
    List<Product> findByClothesCategory(String categoryName);

    @Query("select p from Product p, ClothesCategory cc where p.clothesCategory in (select cc from ClothesCategory cc where cc.name =?1 and cc.brand in (select b from Brand b where b.name =?2))")
    List<Product> findByClothesCategoryAndBrand(String subcategoryName, String brand);

    @Query("select p from Product p, ClothesCategory cc " +
            "where p.clothesCategory in " +
            "(select cc from ClothesCategory cc where cc.name =?1 " +
            "and cc.peopleCategory in " +
            "(select cp from PeopleCategory cp where cp.name =?2)" +
            "and cc.brand in " +
            "(select b from Brand b where b.name =?3)) ")
    List<Product> findByClothesCategoryAndBrandAAndPeopleCat(String categoryName, String peopleCat, String brand);

    @Query("select p from Product p, ClothesCategory cc " +
            "where p.clothesCategory in " +
            "(select cc from ClothesCategory cc where cc.name =?1 " +
            "and cc.peopleCategory in " +
            "(select cp from PeopleCategory cp where cp.name =?2)) ")
    List<Product> findByClothesCategoryAndPeopleCat(String categoryName, String peopleCat);

    @Query("select p from Product p, ClothesCategory cc " +
            "where p.clothesCategory in " +
            "(select cc from ClothesCategory cc " +
            "where cc.brand in" +
            "( select b from Brand b where b.name =?1) " +
            "and cc.peopleCategory in " +
            "(select cp from PeopleCategory cp where cp.name =?2)) ")
    List<Product> findByBrandAndPeopleCat(String brand, String peopleCat);

    void deleteByName(String name);
}
