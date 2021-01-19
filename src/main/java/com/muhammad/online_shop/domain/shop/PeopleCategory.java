package com.muhammad.online_shop.domain.shop;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PeopleCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "people_category_name")
    private String name;

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "peopleCategory", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonManagedReference
    private Set<ClothesCategory> clothesCategories = new HashSet<>();

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

   public Set<ClothesCategory> getClothesCategories() {
        return clothesCategories;
    }

    public void setClothesCategories(Set<ClothesCategory> clothesCategories) {
        this.clothesCategories = clothesCategories;
    }

   /* @Override
    public String toString() {
        return "PeopleCategory{" +
                ", name='" + name;
    }*/
}