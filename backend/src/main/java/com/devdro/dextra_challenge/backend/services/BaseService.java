package com.devdro.dextra_challenge.backend.services;

import com.devdro.dextra_challenge.backend.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T createOrUpdate(T entity);
    List<T> findAll();
    Optional<T> find(Long id);
    void delete(Long id);
    void delete(T entity);
}
