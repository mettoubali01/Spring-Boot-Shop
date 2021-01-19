package com.muhammad.online_shop.service;

import com.muhammad.online_shop.domain.shop.ClothesCategory;
import com.muhammad.online_shop.domain.shop.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public abstract class GenericAbstractService<T, ID> implements IGenericService<T, ID> {

    protected JpaRepository<T, ID> repository;

    @Override
    public T getById(ID identifier) {
        return repository.findById(identifier).get();
    }

    @Override
    public Collection<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T saveNew(T object) {
        return repository.save(object);
    }

    @Override
    public T update(ID identifier, T object) {
        return repository.save(object);
    }

    @Override
    public Boolean deleteById(ID identifier) {

        try {
            repository.deleteById(identifier);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }
}
