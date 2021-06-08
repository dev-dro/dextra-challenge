package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.IngredientMenu;
import com.devdro.dextra_challenge.backend.repositories.IngredientMenuRepository;
import com.devdro.dextra_challenge.backend.services.IngredientMenuService;
import com.devdro.dextra_challenge.backend.services.NamedEntityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientMenuJpaService extends NamedEntityJpaService<IngredientMenu> implements IngredientMenuService {

    private final IngredientMenuRepository ingredientMenuRepository;

    public IngredientMenuJpaService(IngredientMenuRepository ingredientMenuRepository) {
        this.ingredientMenuRepository = ingredientMenuRepository;
    }

    @Override
    protected IngredientMenuRepository getRepository() {
        return ingredientMenuRepository;
    }
}
