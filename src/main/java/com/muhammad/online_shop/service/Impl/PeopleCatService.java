package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.shop.PeopleCategory;
import com.muhammad.online_shop.repository.IPeopleCategoryRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.stereotype.Service;

@Service
public class PeopleCatService<T, ID> extends GenericAbstractService<PeopleCategory, Long> {

    public PeopleCatService(IPeopleCategoryRepository iPeopleCatRepository) {
        this.repository = iPeopleCatRepository;
    }

   /* public Brand findPeopleByName(String name){
        return ((IPeopleCategoryRepository) repository).findBrandByName(name);
    }

    public Collection<Brand> findBrandByPeopleCategory(String name){
        return ((IPeopleCategoryRepository)repository).findBrandsByPeopleCategory(name);
    }*/
}
