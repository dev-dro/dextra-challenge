package com.devdro.dextra_challenge.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemMenu extends NamedEntity {

    @OneToMany(mappedBy = "itemMenu", fetch = FetchType.EAGER)
    private List<IngredientOrder> ingredients;

}
