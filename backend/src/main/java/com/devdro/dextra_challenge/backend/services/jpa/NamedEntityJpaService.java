package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.NamedEntity;
import com.devdro.dextra_challenge.backend.repositories.NamedEntityRepository;
import com.devdro.dextra_challenge.backend.services.NamedEntityService;

import java.util.List;
import java.util.Optional;

public abstract class NamedEntityJpaService<T extends NamedEntity> extends BaseJpaService<T> implements NamedEntityService<T> {

    protected abstract NamedEntityRepository<T> getRepository();

    @Override
    public List<T> findAllByName(String name) {
        return getRepository().findAllByNameLikeIgnoreCase(name);
    }

    @Override
    public Optional<T> find(String name) {
        return getRepository().findFirstByNameLikeIgnoreCase(name);
    }
}
