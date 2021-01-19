package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.service.Impl.ClothesCategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clothes_category")
public class ClothesCategoryController extends GenericAbstractController<ClothesCategory, Long> {

    public ClothesCategoryController(ClothesCategoryService clothesCategoryService) {
        this.service = clothesCategoryService;
    }

    @RequestMapping(value = {"/a/{name}/{brand}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ClothesCategory> getClotheCatByName(@PathVariable String name, @PathVariable String brand){
        System.out.println("name " + name + " result " + ((ClothesCategoryService)service).getByNameAndPeople(name, brand));
        return ((ClothesCategoryService)service).getByNameAndPeople(name, brand);
    }
}
