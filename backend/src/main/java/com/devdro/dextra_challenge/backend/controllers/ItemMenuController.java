package com.devdro.dextra_challenge.backend.controllers;

import com.devdro.dextra_challenge.backend.model.ItemMenu;
import com.devdro.dextra_challenge.backend.services.BaseService;
import com.devdro.dextra_challenge.backend.services.ItemMenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/item-menu")
public class ItemMenuController extends BaseController<ItemMenu> {

    private final ItemMenuService itemMenuService;

    public ItemMenuController(ItemMenuService itemMenuService) {
        this.itemMenuService = itemMenuService;
    }

    @Override
    protected BaseService<ItemMenu> getService() {
        return itemMenuService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ItemMenu> findByName(@PathVariable String name) {
        Optional<ItemMenu> optionalEntity = itemMenuService.find(name);
        return optionalEntity
                .map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
