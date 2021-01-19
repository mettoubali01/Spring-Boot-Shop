package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.customer.Address;
import com.muhammad.online_shop.domain.customer.Customer;
import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.domain.shop.Product;
import com.muhammad.online_shop.service.Impl.AddressService;
import com.muhammad.online_shop.service.Impl.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/address")
public class AddressController extends GenericAbstractController<Address, Long> {

    public AddressController(AddressService addressService){
        this.service = addressService;
    }

    @Transactional
    @RequestMapping(value = {"/delete/{name}", "/delete/{name}/"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteByName(@PathVariable String name){
        return ((AddressService)service).removeByStreetName(name);
    }
}
