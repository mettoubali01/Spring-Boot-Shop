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

    protected static int counter = 0;
    protected final static int minutesToExpire = 5;

    @Autowired
    protected ICartItemRepository iCartItemRepository;

    @Autowired
    protected ICustomerRepository iCustomerRepository;

    @Autowired
    protected IProductRepository iProductRepository;

    public CartService(ICartRepository iCartRepository) {
        this.repository = iCartRepository;
    }

    //cron executing every minute
    @Scheduled(cron = "0 * * * * *")
    public void createExpireDate() {
        Timestamp timestamp;
        Collection<Cart> carts = super.findAll();
        timestamp = Timestamp.from(Instant.now());

        if (carts.size() == 0) {
            System.out.println("We don't have any cart created");
        } else {
            for (Cart cart : carts) {
                timestamp.setTime(timestamp.getTime() + ((counter++) * 60 * 1000));

                int b3 = timestamp.compareTo(cart.getExpiration_date());
                if (b3 == 0 || b3 > 0)
                    super.deleteById(cart.getId());

            }
        }
    }

    //Control the product if is the same sum qty
    public Collection<Cart> createCart(String nif, long productId) {
        Cart newCart;

        //getting the costumer by the nif
        Customer customer = getCustomerByNif(nif);

        //expiration Date: to remove the cart with his items
        Timestamp expirationDate = expireIn();

        //controlling the always we have a only one Cart for the items cart
        ArrayList<Cart> cart = (ArrayList<Cart>) super.findAll();
        if (cart.size() > 0) {
            newCart = cart.get(0);
        } else {
            newCart = new Cart(customer, expirationDate, 0, true);
            super.saveNew(newCart);
        }

        //getting the product by the id
        Product product = getProductById(productId);

        //save the new cart items
        createCartITem(newCart, product);

        //calculating the subTotal
        calculateSubTotal(newCart.getId());

        return super.findAll();
    }

    public void createCartITem(Cart cart, Product product) {

        CartItem cartItem;
        boolean productExists = iCartItemRepository.existsByProductId(product.getId());

        if (productExists) {
            cartItem = iCartItemRepository.findByProductId(product.getId());
            cartItem.setQty(cartItem.getQty()+1);
        } else {
            cartItem = new CartItem(product, (int) product.getPrice(), 1, 0, cart);
        }

        iCartItemRepository.save(cartItem);
    }

    public Timestamp expireIn() {

        Timestamp expirationDate = Timestamp.from(Instant.now());
        expirationDate.setTime(expirationDate.getTime() + (minutesToExpire * 60 * 1000));

        return expirationDate;
    }

    public void calculateSubTotal(long cartId) {

        int total = 0;
        Cart savedCart = super.getById(cartId);
        if (savedCart.getCartItems().size() > 0) {
            for (CartItem cartItem : savedCart.getCartItems()) {
                if (cartItem.getQty()>1){
                    for (int i = 0; i < cartItem.getQty(); i++)
                        total += cartItem.getPrice();
                }else {
                    total += cartItem.getPrice();
                }
            }
            savedCart.setSubTotal(total);
        }
        super.update(0L, savedCart);
    }

    public Customer getCustomerByNif(String nif) {

        return iCustomerRepository.findByNif(nif);
    }

    public Product getProductById(long productId) {

        return iProductRepository.findById(productId).get();
    }
}
