package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.ItemMenu;
import com.devdro.dextra_challenge.backend.repositories.ItemMenuRepository;
import com.devdro.dextra_challenge.backend.services.ItemMenuService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemMenuJpaService extends NamedEntityJpaService<ItemMenu> implements ItemMenuService {

    private final ItemMenuRepository itemMenuRepository;

    public ItemMenuJpaService(ItemMenuRepository itemMenuRepository) {
        this.itemMenuRepository = itemMenuRepository;
    }

    @Override
    protected ItemMenuRepository getRepository() {
        return itemMenuRepository;
    }

    @Override
    public Optional<ItemMenu> find(String name) {
        Optional<ItemMenu> optionalItemMenu = super.find(name);
        optionalItemMenu.ifPresent(itemMenu -> itemMenu.setIngredients(itemMenu.getIngredients()));
        return optionalItemMenu;
    }
}
