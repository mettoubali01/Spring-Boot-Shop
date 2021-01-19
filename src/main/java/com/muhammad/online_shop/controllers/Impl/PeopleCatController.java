package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.shop.PeopleCategory;
import com.muhammad.online_shop.service.Impl.PeopleCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peopleCat")
public class PeopleCatController extends GenericAbstractController<PeopleCategory, Long> {

    public PeopleCatController(PeopleCatService peopleCatService) {
        this.service = peopleCatService;
    }

   /* @Override
    public Collection<PeopleCategory> get() {
        List<PeopleCategory> peopleCategoryList = (ArrayList) service.findAll();
        for (PeopleCategory peopleCategory : peopleCategoryList) {

            System.out.print("The people Category " + peopleCategory.getName() + " => ");
           *//* for (ClothesCategory clothesCategoryL : peopleCategory.getClothesCategories()) {
                System.out.print(clothesCategoryL.getName() + " ");
               *//**//* for (ClothesCategory clothesCategory : clothesCategoryL.getClothesCategories()){
                    System.out.print("");
                }
                System.out.println();*//**//*
            }*//*
            System.out.println();
        }
        return service.findAll();*/
    //}
}
