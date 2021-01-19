package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.customer.Address;
import com.muhammad.online_shop.domain.customer.Customer;
import com.muhammad.online_shop.service.Impl.AddressService;
import com.muhammad.online_shop.service.Impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends GenericAbstractController<Customer, Long> {

    @Autowired
    protected AddressService addressService;

    public CustomerController(CustomerService customerService){
        this.service = customerService;
    }

    @RequestMapping(value = {"/{identifier}/update_address", "/{identifier}/update_address/"}, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer put(@PathVariable long identifier, @RequestBody Address address) {
        Customer customer = service.getById(identifier);

        Address address1 = addressService.getById(customer.getAddress().getId());
        address1.setCalle(address.getCalle());
        address1.setNumber(address.getNumber());
        address1.setFloor(address.getFloor());
        address1.setZip(address.getZip());
        address1.setState(address.getState());
        address1.setCity(address.getCity());
        address1.setCountry(address.getCountry());
        addressService.update(0L, address1);
        customer.setAddress(address1);

        return super.getById(identifier);
    }

    @Transactional
    @RequestMapping(value = {"/delete/{nif}", "/delete/{nif}/"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean RemoveByNif(@PathVariable String nif){
        return ((CustomerService)service).deleteByNif(nif);
    }
}