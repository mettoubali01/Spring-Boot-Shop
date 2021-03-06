package com.muhammad.online_shop.controllers;

import java.util.Collection;

public interface IGenericController<T, ID> {

    T getById(ID identifier);

    Collection<T> get();

    T post(T object);

    T put(ID identifier, T object);

    Boolean delete(ID identifier);
}
