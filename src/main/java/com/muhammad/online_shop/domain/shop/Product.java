package com.muhammad.online_shop.domain.shop;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name")
    private String name;
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(optional = true)
    @JoinColumn(name = "clothes_cat_fk", nullable = true)
    private ClothesCategory clothesCategory;

    //@JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private Set<Quantity> quantity = new HashSet<>();
   /* @OneToOne(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private CartItem cartItem;*/
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClothesCategory getClothesCategory() {
        return clothesCategory;
    }

    public void setClothesCategory(ClothesCategory clothesCategory) {
        this.clothesCategory = clothesCategory;
    }

    public Set<Quantity> getQuantity() {
        return quantity;
    }

    public void setQuantity(Set<Quantity> quantity) {
        this.quantity = quantity;
    }

    /*public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }*/

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                /*", quantity=" + quantity +*/
                '}';
    }
}
