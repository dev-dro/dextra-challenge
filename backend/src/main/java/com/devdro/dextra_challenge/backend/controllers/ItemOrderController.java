package com.devdro.dextra_challenge.backend.controllers;

import com.devdro.dextra_challenge.backend.model.ItemOrder;
import com.devdro.dextra_challenge.backend.services.ItemOrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-item")
public class ItemOrderController extends BaseController<ItemOrder> {

    private final ItemOrderService itemOrderService;

    public ItemOrderController(ItemOrderService itemOrderService) {
        this.itemOrderService = itemOrderService;
    }

    @Override
    protected ItemOrderService getService() {
        return itemOrderService;
    }

    @PostMapping(value = "/calculate-price", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemOrder> calculatePrice(@RequestBody ItemOrder itemOrder) {
        itemOrderService.calculatePrice(itemOrder);
        return ResponseEntity.ok(itemOrder);
    }
}
