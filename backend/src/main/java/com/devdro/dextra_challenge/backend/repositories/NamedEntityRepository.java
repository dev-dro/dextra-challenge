package com.devdro.dextra_challenge.backend.repositories;

import com.devdro.dextra_challenge.backend.model.NamedEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface NamedEntityRepository<T extends NamedEntity> extends BaseEntityRepository<T> {

    List<T> findAllByNameLikeIgnoreCase(String name);
    Optional<T> findFirstByNameLikeIgnoreCase(String name);
}
