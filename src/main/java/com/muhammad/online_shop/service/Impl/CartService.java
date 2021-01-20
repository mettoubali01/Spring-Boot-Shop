package com.muhammad.online_shop.service.Impl;

import com.muhammad.online_shop.domain.customer.Cart;
import com.muhammad.online_shop.domain.customer.CartItem;
import com.muhammad.online_shop.domain.customer.Customer;
import com.muhammad.online_shop.domain.shop.Product;
import com.muhammad.online_shop.repository.ICartItemRepository;
import com.muhammad.online_shop.repository.ICartRepository;
import com.muhammad.online_shop.repository.ICustomerRepository;
import com.muhammad.online_shop.repository.IProductRepository;
import com.muhammad.online_shop.service.GenericAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CartService extends GenericAbstractService<Cart, Long> {

    static int counter = 0;
    final static int minutesToExpire = 5;
    @Autowired
    protected ICartItemRepository iCartItemRepository;

    @Autowired
    protected ICustomerRepository iCustomerRepository;

    @Autowired
    protected IProductRepository iProductRepository;

    public CartService(ICartRepository iCartRepository) {
        this.repository = iCartRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void createExpireDate(){
        Timestamp timestamp;
        Collection<Cart> carts = super.findAll();
        timestamp = Timestamp.from(Instant.now());

        if (carts.size() == 0) {
            System.out.println("We don't have any cat created");
        }else {
            for (Cart cart : carts) {
                timestamp.setTime(timestamp.getTime() + ((counter++)*60*1000));
                System.out.println(timestamp + " *** " + cart.getDate_creation());

                int b3 = timestamp.compareTo(cart.getDate_creation());
                if (b3 == 0 || b3 > 0) {
                    super.deleteById(cart.getId());
                    System.out.println("Cart and items are deleted");

                }
            }
        }
    }

    //Control the product if is the same sum qty
    public Collection<Cart> createCart(String nif, long productId){
        int total = 0;
        Cart newCart;

        Customer customer = iCustomerRepository.findByNif(nif);
        Timestamp creationDate = Timestamp.from(Instant.now());
        creationDate.setTime(creationDate.getTime() + (minutesToExpire*60*1000));
        System.out.println("Creation " + creationDate);

        ArrayList<Cart> cart = (ArrayList<Cart>) super.findAll();
        if (cart.size() > 0) {
            newCart = cart.get(0);
        }else {
            newCart = new Cart(customer, creationDate ,0,true);
            super.saveNew(newCart);
        }

        //cart item
        Product product = iProductRepository.findById(productId).get();
        CartItem cartItem = new CartItem(product, (int) product.getPrice(), 1, 0, newCart);
        iCartItemRepository.save(cartItem);

        Cart savedCart = super.getById(newCart.getId());
        System.out.println("WWWWWWWWWW " + savedCart.getCartItems().size());
        if (savedCart.getCartItems().size() > 0){
            for (CartItem c : savedCart.getCartItems()) {
                total += c.getPrice();
                System.out.println("Total " + total + " c " + c.getPrice());
            }
            savedCart.setSubTotal(total);
        }

        System.out.println("Subtotal " + product);

        return super.findAll();
    }
}
