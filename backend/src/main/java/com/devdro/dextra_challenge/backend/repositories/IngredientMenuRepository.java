package com.devdro.dextra_challenge.backend.repositories;

import com.devdro.dextra_challenge.backend.model.IngredientMenu;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientMenuRepository extends NamedEntityRepository<IngredientMenu> {
}
