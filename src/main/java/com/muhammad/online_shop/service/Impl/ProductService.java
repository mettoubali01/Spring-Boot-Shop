 package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.shop.Product;
import com.muhammad.online_shop.repository.IProductRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService<T, ID> extends GenericAbstractService<Product, Long> {

    public ProductService(IProductRepository iProductRepository) {
        this.repository = iProductRepository;
    }

    public List<Product> getProductByClothesCatName(String name){
        System.out.println("Name " + name + ((IProductRepository)repository).findByClothesCategory(name));
        return ((IProductRepository)repository).findByClothesCategory(name);
    }

    public List<Product> getProductByClothesCatAndBrand(String clotheCatName, String brandName){
        System.out.println("Name " + clotheCatName + " brand " + brandName + " sisze " + ((IProductRepository)repository).findByClothesCategoryAndBrand(clotheCatName, brandName).size());
        return ((IProductRepository)repository).findByClothesCategoryAndBrand(clotheCatName, brandName);
    }

    public List<Product> getProductByClothesCatAndBrandAndPeopleCat(String clotheCatName, String peopleCatName, String brandName){
        System.out.println("Name " + clotheCatName + " brand " + brandName + " sisze " + ((IProductRepository)repository).findByClothesCategoryAndBrandAAndPeopleCat(clotheCatName, peopleCatName, brandName).size());
        return ((IProductRepository)repository).findByClothesCategoryAndBrandAAndPeopleCat(clotheCatName, peopleCatName, brandName);
    }

    public List<Product> getProductByClothesCatAndPeopleCat(String clotheCatName, String peopleCatName){
        System.out.println("Name " + clotheCatName + " brand " + peopleCatName + " sisze " + ((IProductRepository)repository).findByClothesCategoryAndPeopleCat(clotheCatName, peopleCatName).size());
        return ((IProductRepository)repository).findByClothesCategoryAndPeopleCat(clotheCatName, peopleCatName);
    }

    public void deleteProductNyName(String name){
        System.out.println("name " + name);

        ((IProductRepository)repository).deleteByName(name);
    }
}
