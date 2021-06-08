package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.IngredientOrder;
import com.devdro.dextra_challenge.backend.repositories.IngredientOrderRepository;
import com.devdro.dextra_challenge.backend.repositories.NamedEntityRepository;
import com.devdro.dextra_challenge.backend.services.IngredientOrderService;
import org.springframework.stereotype.Service;

@Service
public class IngredientOrderJpaService extends NamedEntityJpaService<IngredientOrder> implements IngredientOrderService {

    private final IngredientOrderRepository ingredientOrderRepository;

    public IngredientOrderJpaService(IngredientOrderRepository ingredientOrderRepository) {
        this.ingredientOrderRepository = ingredientOrderRepository;
    }

    @Override
    protected IngredientOrderRepository getRepository() {
        return ingredientOrderRepository;
    }
}
