package com.devdro.dextra_challenge.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IngredientOrder extends NamedEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private ItemOrder itemOrder;

    private Integer quantity;

    @ManyToOne
    @JsonIgnore
    private ItemMenu itemMenu;

    public IngredientOrder(Long id, String name, ItemOrder itemOrder, Integer quantity, ItemMenu itemMenu) {
        super(id, name);
        this.itemOrder = itemOrder;
        this.quantity = quantity;
        this.itemMenu = itemMenu;
    }

    public IngredientOrder(String name, Integer quantity) {
        super(name);
        this.quantity = quantity;
    }
}
