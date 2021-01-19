package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.domain.shop.Product;
import com.muhammad.online_shop.service.Impl.ClothesCategoryService;
import com.muhammad.online_shop.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericAbstractController<Product, Long> {

    @Autowired
    protected ClothesCategoryService iClothesCatService;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @RequestMapping(value = {"/category/{category}", "/category/{category}/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsByClothesCat(@PathVariable String category){
        return ((ProductService)service).getProductByClothesCatName(category);
    }

    @RequestMapping(value = {"/category/{category}/brand/{brand}", "/category/{category}/brand/{brand}/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsByClothesCatAndBrand(@PathVariable String category, @PathVariable String brand){
        return ((ProductService)service).getProductByClothesCatAndBrand(category, brand);
    }

    @RequestMapping(value = {"/category/{category}/people_category/{people}/brand/{brand}", "/category/{category}/people_category/{people}/brand/{brand}/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsByClothesCatAndBrandAndPeopleCat(@PathVariable String category, @PathVariable String people, @PathVariable String brand){
        return ((ProductService)service).getProductByClothesCatAndBrandAndPeopleCat(category, people, brand);
    }

    @RequestMapping(value = {"/category/{category}/people_category/{people}", "/category/{category}/people_category/{people}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsByClothesCatAndPeople(@PathVariable String category, @PathVariable String people){
        return ((ProductService)service).getProductByClothesCatAndPeopleCat(category, people);
    }

    @RequestMapping(value = {"/add", "/add/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Override
    public Product post(@RequestBody Product object) {
        return super.post(object);
    }

    @RequestMapping(value = {"/update/{identifier}", "/update/{identifier}/"}, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product put(@PathVariable long identifier, @RequestBody ClothesCategory clothesCategory) {
        ClothesCategory clothesCategory1 = iClothesCatService.getById(clothesCategory.getId());
        System.out.println("ID " + clothesCategory.getId());
        Product product = super.getById(identifier);
        product.setClothesCategory(clothesCategory1);
        return super.put(identifier,product);
    }

    @Transactional
    @RequestMapping(value = {"/delete{name}", "/delete/{name}/"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteByName(@PathVariable String name) {
        try{
            ((ProductService)service).deleteProductNyName(name);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }
}
