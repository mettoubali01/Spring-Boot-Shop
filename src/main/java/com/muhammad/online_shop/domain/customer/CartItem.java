package com.muhammad.online_shop.domain.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.muhammad.online_shop.domain.shop.Product;
import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int price;
    @Column(name = "quantity")
    private int qty;
    private int discount;
    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonBackReference
    private Cart cart;

    public CartItem() { }

    public CartItem(Product product, int price, int qty, int discount, Cart cart) {
        this.product = product;
        this.price = price;
        this.qty = qty;
        this.discount = discount;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", qty=" + qty +
                ", discount=" + discount +
/*
                ", cart=" + cart +
*/
                '}';
    }
}
