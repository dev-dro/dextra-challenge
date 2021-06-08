package com.devdro.dextra_challenge.backend.services;

import com.devdro.dextra_challenge.backend.model.ItemOrder;

public interface ItemOrderService extends BaseService<ItemOrder> {

    void calculatePrice(ItemOrder itemOrder);
}
