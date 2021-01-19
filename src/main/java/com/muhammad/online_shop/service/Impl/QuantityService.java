package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.shop.Quantity;
import com.muhammad.online_shop.repository.IQtyRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.stereotype.Service;

@Service
public class QuantityService extends GenericAbstractService<Quantity, Long> {

    public QuantityService(IQtyRepository iQtyRepository) {
        this.repository = iQtyRepository;
    }
}
