package com.muhammad.online_shop.controllers.Impl;

import com.muhammad.online_shop.controllers.GenericAbstractController;
import com.muhammad.online_shop.domain.customer.Cart;
import com.muhammad.online_shop.service.Impl.CartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping(value = "/cart")
public class CartController extends GenericAbstractController<Cart, Long> {

    public CartController(CartService cartService) {
        this.service = cartService;
    }

    @RequestMapping(value = {"/a/{nif}/{productId}", "/a/{nif}/{productId}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Cart> expitreTime(@PathVariable String nif, @PathVariable long productId) throws InterruptedException {
        return ((CartService)service).createCart(nif, productId);
    }
}
