package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.customer.Address;
import com.muhammad.online_shop.repository.IAddressRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericAbstractService<Address, Long> {

    public AddressService(IAddressRepository iAddressRepository){
        this.repository = iAddressRepository;
    }

    public boolean removeByStreetName(String street){
        try {
            ((IAddressRepository)repository).deleteByCalle(street);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }
}
