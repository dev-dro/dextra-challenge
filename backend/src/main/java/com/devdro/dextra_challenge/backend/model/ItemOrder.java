package com.devdro.dextra_challenge.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemOrder extends BaseEntity {

    private BigDecimal price;

    @OneToMany(mappedBy = "itemOrder", cascade = CascadeType.ALL)
    private List<IngredientOrder> ingredients;

    @ManyToOne
    @JoinColumn(name = "client_order_id", insertable = false, updatable = false)
    private ClientOrder clientOrder;

    public ItemOrder(Long id, BigDecimal price, List<IngredientOrder> ingredients, ClientOrder clientOrder) {
        super(id);
        this.price = price;
        this.ingredients = ingredients;
        this.clientOrder = clientOrder;
    }
}
