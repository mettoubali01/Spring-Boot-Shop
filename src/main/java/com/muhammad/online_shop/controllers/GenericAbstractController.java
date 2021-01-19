package com.muhammad.online_shop.controllers;

import com.muhammad.online_shop.service.IGenericService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Collection;

public abstract class GenericAbstractController<T, ID> implements IGenericController<T, ID> {

    protected IGenericService<T, ID> service;

    @RequestMapping(value = {"/{identifier}", "/{identifier}/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public T getById(@PathVariable ID identifier) {
        System.out.println(" abstract ID "  + identifier);
        return service.getById(identifier);
    }

    @RequestMapping(value = {"/all", "/all/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Collection<T> get() {
        return service.findAll();
    }

    @RequestMapping(value = {"/add", "/add/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public T post(@RequestBody T object) {
        System.out.println("Post ");
        return service.saveNew(object);
    }

    @RequestMapping(value = {"/update/{identifier}", "/update/{identifier}/"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public T put(ID identifier, T object) {

        return service.update(identifier, object);
    }

    @RequestMapping(value = {"/delete", "/delete/"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Boolean delete(ID identifier) {
        return service.deleteById(identifier);
    }
}