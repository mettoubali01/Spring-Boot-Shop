package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.shop.Brand;
import com.muhammad.online_shop.service.Impl.BrandService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/brand")
public class BrandController extends GenericAbstractController<Brand, Long> {

    public BrandController(BrandService brandService) {
        this.service = brandService;
    }

    @RequestMapping(value = {"/add", "/add/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Brand post(@RequestBody Brand brand) {
        return super.post(brand);
    }

    @Override
    public Brand put(@PathVariable Long identifier, @RequestBody Brand object) {
        Brand brand = this.service.getById(identifier);
        System.out.println(object + " " + brand);

        brand.setName(object.getName());
        return super.put(identifier, brand);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand getBrandByName(@RequestParam String name){
        return ((BrandService) service).findBrandByName(name);
    }
}



