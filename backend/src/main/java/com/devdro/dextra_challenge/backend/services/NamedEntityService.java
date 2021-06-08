package com.devdro.dextra_challenge.backend.services;

import com.devdro.dextra_challenge.backend.model.NamedEntity;

import java.util.List;
import java.util.Optional;

public interface NamedEntityService<T extends NamedEntity> extends BaseService<T> {

    List<T> findAllByName(String name);
    Optional<T> find(String name);
}
