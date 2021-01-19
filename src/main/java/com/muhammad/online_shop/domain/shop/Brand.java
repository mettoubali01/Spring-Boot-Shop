package com.muhammad.online_shop.domain.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.source.doctree.SerialDataTree;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "brand_name")
    private String name;
    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
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

    @Override
    public String toString() {
        return "Brand{" +
                ", name='" + name + '\'' +
                '}';
    }
}
