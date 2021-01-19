package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.shop.Quantity;
import com.muhammad.online_shop.service.Impl.QuantityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quantity")
public class QuantityController extends GenericAbstractController<Quantity, Long> {

    public QuantityController(QuantityService quantityService) {
        this.service = quantityService;
    }
}