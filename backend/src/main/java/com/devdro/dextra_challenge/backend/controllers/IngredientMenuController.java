package com.devdro.dextra_challenge.backend.controllers;

import com.devdro.dextra_challenge.backend.model.IngredientMenu;
import com.devdro.dextra_challenge.backend.services.IngredientMenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientMenuController extends BaseController<IngredientMenu> {

    public final IngredientMenuService ingredientMenuService;

    public IngredientMenuController(IngredientMenuService ingredientMenuService) {
        this.ingredientMenuService = ingredientMenuService;
    }

    @Override
    protected IngredientMenuService getService() {
        return ingredientMenuService;
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IngredientMenu> findByName(@PathVariable String name) {
        Optional<IngredientMenu> optionalIngredient = ingredientMenuService.find(name);
        return optionalIngredient
                .map(ingredient -> new ResponseEntity<>(ingredient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
