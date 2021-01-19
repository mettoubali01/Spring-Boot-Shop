package com.muhammad.online_shop.domain.shop;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "clothes_category")
public class ClothesCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "people_cat_fk")
    @JsonBackReference
    private PeopleCategory peopleCategory;

    @ManyToOne
    @JoinColumn(name = "brand_fk")
    private Brand brand;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_cat_parent")
    //@JsonBackReference
    private ClothesCategory clothesCatParent;

    @OneToMany(mappedBy = "clothesCatParent", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@JsonManagedReference
    @Fetch(FetchMode.JOIN)
    private List<ClothesCategory> clothesCategories = new ArrayList<>();

    @OneToMany(mappedBy = "clothesCategory", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    private Set<Product> products = new HashSet<>();

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ClothesCategory getClothesCatParent() {
        return clothesCatParent;
    }

    public void setClothesCatParent(ClothesCategory clothesCatParent) {
        this.clothesCatParent = clothesCatParent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PeopleCategory getPeopleCategory() {
        return peopleCategory;
    }

    public void setPeopleCategory(PeopleCategory peopleCategory) {
        this.peopleCategory = peopleCategory;
    }

    public List<ClothesCategory> getClothesCategories() {
        return clothesCategories;
    }

    public void setClothesCategories(List<ClothesCategory> clothesCategories) {
        this.clothesCategories = clothesCategories;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
