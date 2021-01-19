package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.customer.Customer;
import com.muhammad.online_shop.repository.ICustomerRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericAbstractService<Customer, Long> {

    public CustomerService(ICustomerRepository iCustomerRepository){
        this.repository = iCustomerRepository;
    }

    public boolean deleteByNif(String nif){
        try{
            ((ICustomerRepository)repository).deleteByNif(nif);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }
}
