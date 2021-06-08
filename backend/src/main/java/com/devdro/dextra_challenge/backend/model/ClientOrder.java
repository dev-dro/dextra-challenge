package com.devdro.dextra_challenge.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientOrder extends NamedEntity {

    private BigDecimal finalPrice;

    @OneToMany(mappedBy = "clientOrder")
    private List<ItemOrder> items;

    public ClientOrder(Long id, String name, BigDecimal finalPrice, List<ItemOrder> items) {
        super(id, name);
        this.finalPrice = finalPrice;
        this.items = items;
    }
}
