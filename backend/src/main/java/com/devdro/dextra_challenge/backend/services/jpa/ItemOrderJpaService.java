package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.constants.Constants;
import com.devdro.dextra_challenge.backend.model.IngredientOrder;
import com.devdro.dextra_challenge.backend.model.ItemOrder;
import com.devdro.dextra_challenge.backend.repositories.ItemOrderRepository;
import com.devdro.dextra_challenge.backend.services.IngredientMenuService;
import com.devdro.dextra_challenge.backend.services.IngredientOrderService;
import com.devdro.dextra_challenge.backend.services.ItemOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.devdro.dextra_challenge.backend.constants.Constants.BACON_NAME;
import static com.devdro.dextra_challenge.backend.constants.Constants.CHEESE_NAME;
import static com.devdro.dextra_challenge.backend.constants.Constants.HAMBURGER_NAME;
import static com.devdro.dextra_challenge.backend.constants.Constants.LETTUCE_NAME;
import static com.devdro.dextra_challenge.backend.constants.Constants.PROMOTION_LIGHT_DISCOUNT;

@Service
public class ItemOrderJpaService extends BaseJpaService<ItemOrder> implements ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;
    private final IngredientMenuService ingredientMenuService;
    private final IngredientOrderService ingredientOrderService;

    public ItemOrderJpaService(ItemOrderRepository itemOrderRepository, IngredientMenuService ingredientMenuService, IngredientOrderService ingredientOrderService) {
        this.itemOrderRepository = itemOrderRepository;
        this.ingredientMenuService = ingredientMenuService;
        this.ingredientOrderService = ingredientOrderService;
    }

    @Override
    protected ItemOrderRepository getRepository() {
        return itemOrderRepository;
    }

    @Override
    public ItemOrder createOrUpdate(ItemOrder itemOrder) {
        List<IngredientOrder> ingredients = itemOrder.getIngredients();
        itemOrder.setIngredients(null);
        super.createOrUpdate(itemOrder);
        ingredients.forEach(ingredient -> {
            ingredient.setItemOrder(itemOrder);
            ingredientOrderService.createOrUpdate(ingredient);
        });
        itemOrder.setIngredients(ingredients);
        return itemOrder;
    }

    @Override
    public void calculatePrice(ItemOrder itemOrder) {

        BigDecimal finalPrice = BigDecimal.ZERO;

        boolean hasLettuce = false;
        boolean hasBacon = false;

        for (IngredientOrder ingredient : itemOrder.getIngredients()) {

            BigDecimal price = ingredientMenuService.find(ingredient.getName()).orElseThrow().getPrice();
            Integer quantity = ingredient.getQuantity();

            if (ingredient.getName().equalsIgnoreCase(HAMBURGER_NAME)) {
                quantity = ingredient.getQuantity() - (ingredient.getQuantity() / Constants.PROMOTION_LOT_OF_MEAT_NUMBER);
            } else if (ingredient.getName().equalsIgnoreCase(CHEESE_NAME)) {
                quantity = ingredient.getQuantity() - (ingredient.getQuantity() / Constants.PROMOTION_LOT_OF_CHEESE_NUMBER);
            } else if (ingredient.getName().equalsIgnoreCase(LETTUCE_NAME)) {
                hasLettuce = true;
            } else if (ingredient.getName().equalsIgnoreCase(BACON_NAME)) {
                hasBacon = true;
            }

            finalPrice = finalPrice.add(price.multiply(BigDecimal.valueOf(quantity)));
        }

        if (hasLettuce && !hasBacon) {
            finalPrice = BigDecimal.ONE.subtract(BigDecimal.valueOf(PROMOTION_LIGHT_DISCOUNT / 100))
                    .multiply(finalPrice);
        }

        itemOrder.setPrice(finalPrice);
    }
}
