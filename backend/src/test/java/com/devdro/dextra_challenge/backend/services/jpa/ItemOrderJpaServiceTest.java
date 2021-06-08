package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.constants.Constants;
import com.devdro.dextra_challenge.backend.model.IngredientOrder;
import com.devdro.dextra_challenge.backend.model.ItemMenu;
import com.devdro.dextra_challenge.backend.model.ItemOrder;
import com.devdro.dextra_challenge.backend.services.IngredientMenuService;
import com.devdro.dextra_challenge.backend.services.ItemMenuService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static com.devdro.dextra_challenge.backend.constants.Constants.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ItemOrderJpaServiceTest {

    @Autowired
    ItemOrderJpaService itemOrderService;
    @Autowired
    ItemMenuService itemMenuService;
    @Autowired
    IngredientMenuService ingredientMenuService;

    @Test
    void givenItemMenu_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        ItemMenu itemMenu = itemMenuService.find(X_BACON_NAME).orElseThrow();
        BigDecimal correctPrice = calculateIngredientsPrice(itemMenu.getIngredients());

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(itemMenu.getIngredients());
        itemOrderService.calculatePrice(itemOrder);

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    @Test
    void givenOrderWithNoPromotion_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        IngredientOrder lettuce = new IngredientOrder(LETTUCE_NAME, 1);
        IngredientOrder bacon = new IngredientOrder(BACON_NAME, 1);
        IngredientOrder cheese = new IngredientOrder(CHEESE_NAME, 1);
        BigDecimal correctPrice = calculateIngredientsPrice(Arrays.asList(lettuce, bacon, cheese));

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(Arrays.asList(lettuce, bacon, cheese));
        itemOrderService.calculatePrice(itemOrder);

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    @Test
    void givenOrderWithLightPromotion_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        IngredientOrder lettuce = new IngredientOrder(LETTUCE_NAME, 1);
        IngredientOrder cheese = new IngredientOrder(CHEESE_NAME, 1);
        BigDecimal correctPrice = calculateIngredientsPrice(Arrays.asList(lettuce, cheese))
                .multiply(BigDecimal.valueOf(1 - (PROMOTION_LIGHT_DISCOUNT / 100)));

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(Arrays.asList(lettuce, cheese));
        itemOrderService.calculatePrice(itemOrder);

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    @Test
    void givenOrderWithLotOfMeatPromotion_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        IngredientOrder cheese = new IngredientOrder(CHEESE_NAME, 1);
        IngredientOrder meat = new IngredientOrder(HAMBURGER_NAME, 6);

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(Arrays.asList(cheese, meat));
        itemOrderService.calculatePrice(itemOrder);

        meat.setQuantity(meat.getQuantity() - (meat.getQuantity() / PROMOTION_LOT_OF_MEAT_NUMBER));
        BigDecimal correctPrice = calculateIngredientsPrice(Arrays.asList(cheese, meat));

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    @Test
    void givenOrderWithLotOfCheesePromotion_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        IngredientOrder cheese = new IngredientOrder(CHEESE_NAME, 6);
        IngredientOrder meat = new IngredientOrder(HAMBURGER_NAME, 1);

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(Arrays.asList(cheese, meat));
        itemOrderService.calculatePrice(itemOrder);

        cheese.setQuantity(cheese.getQuantity() - (cheese.getQuantity() / PROMOTION_LOT_OF_CHEESE_NUMBER));
        BigDecimal correctPrice = calculateIngredientsPrice(Arrays.asList(cheese, meat));

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    @Test
    void givenOrderWithAllPromotions_whenCalculateItemOrderPrice_thenReturnCorrectPrice() throws Exception {
        IngredientOrder lettuce = new IngredientOrder(LETTUCE_NAME, 1);
        IngredientOrder cheese = new IngredientOrder(CHEESE_NAME, 6);
        IngredientOrder meat = new IngredientOrder(HAMBURGER_NAME, 6);

        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIngredients(Arrays.asList(lettuce, cheese, meat));
        itemOrderService.calculatePrice(itemOrder);

        cheese.setQuantity(cheese.getQuantity() - (cheese.getQuantity() / PROMOTION_LOT_OF_CHEESE_NUMBER));
        meat.setQuantity(meat.getQuantity() - (meat.getQuantity() / PROMOTION_LOT_OF_MEAT_NUMBER));
        BigDecimal correctPrice = calculateIngredientsPrice(Arrays.asList(lettuce, cheese, meat))
                .multiply(BigDecimal.valueOf(1 - (PROMOTION_LIGHT_DISCOUNT / 100)));

        Assertions.assertEquals(itemOrder.getPrice(), correctPrice);
    }

    private BigDecimal calculateIngredientsPrice(Collection<IngredientOrder> ingredients) throws Exception {
        return ingredients.stream().map(ingredient -> {
            BigDecimal price = ingredientMenuService.find(ingredient.getName()).orElseThrow().getPrice();
            return BigDecimal.valueOf(ingredient.getQuantity()).multiply(price);
        }).reduce(BigDecimal::add).orElseThrow(Exception::new);
    }
}
