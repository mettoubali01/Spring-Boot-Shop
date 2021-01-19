package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.repository.IClothesCategoryRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesCategoryService extends GenericAbstractService<ClothesCategory, Long> {

    public ClothesCategoryService(IClothesCategoryRepository iClothesCategoryRepository) {
        this.repository = iClothesCategoryRepository;
    }

    @Override
    public ClothesCategory getById(Long identifier) {
        return repository.findById(identifier).get();
    }

    public List<ClothesCategory> getByNameAndPeople(String name, String people) {
        System.out.println("Name desde service " + name + " => ");
        return ((IClothesCategoryRepository)repository).findClothesCategoryByNameAndPeopleCategory(name, people);
    }

    /*@Override
    public Collection findAll() {*//*
        List<ClothesCategory> clothesCategoryList = (ArrayList) service.findAll();
        List<ClothesCategory> result = new ArrayList<>();
        for (ClothesCategory clotheCategory : clothesCategoryList) {
            if (clotheCategory.getClothesCategories().size() > 1){
                System.out.println(clotheCategory.getName() + " Siii ");
                result.add(clotheCategory);
            }else{
                System.out.println(clotheCategory.getName() + " Nooo ");
            }
        }
        List<PeopleCategory> peopleCategoryList = (ArrayList) super.findAll();
        for (PeopleCategory peopleCategory : peopleCategoryList) {

            System.out.print("The people Category " + peopleCategory.getName() + " => ");
            for (ClothesCategory clothesCategoryL : peopleCategory.getClothesCategories()) {
                System.out.print(clothesCategoryL.getName() + " ");
                for (ClothesCategory clothesCategory : clothesCategoryL.getClothesCategories()){
                    System.out.print("");
                }
                System.out.println();
            }
            System.out.println();
        }*//*
        return super.findAll();
    }*/
}
