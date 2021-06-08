package com.devdro.dextra_challenge.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IngredientMenu extends NamedEntity {

    private BigDecimal price;

    public IngredientMenu(Long id, String name, BigDecimal price) {
        super(id, name);
        this.price = price;
    }
}
