package com.muhammad.online_shop.service;

import java.util.Collection;

public interface IGenericService<T, ID> {

    T getById(ID identifier);

    Collection<T> findAll();

    T saveNew(T object);

    T update(ID identifier, T object);

    Boolean deleteById(ID identifier);

}
