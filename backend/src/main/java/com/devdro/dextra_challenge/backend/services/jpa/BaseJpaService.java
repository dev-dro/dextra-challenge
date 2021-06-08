package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.BaseEntity;
import com.devdro.dextra_challenge.backend.repositories.BaseEntityRepository;
import com.devdro.dextra_challenge.backend.services.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class BaseJpaService<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseEntityRepository<T> getRepository();

    public T createOrUpdate(T entity) {
        return getRepository().save(entity);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Optional<T> find(Long id) {
        return getRepository().findById(id);
    }

    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }
}
