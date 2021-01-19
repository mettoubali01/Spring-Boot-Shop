package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.shop.Brand;
import com.muhammad.online_shop.repository.IBrandRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.stereotype.Service;

@Service
public class BrandService<T, ID> extends GenericAbstractService<Brand, Long> {

    public BrandService(IBrandRepository iBrandRepository) {
        this.repository = iBrandRepository;
    }

    public Brand findBrandByName(String name){
        return ((IBrandRepository) repository).findBrandByName(name);
    }

    /*public Collection<Brand> findBrandByPeopleCategory(String name){
        return ((IBrandRepository)repository).findBrandsByPeopleCategory(name);
    }*/
}
