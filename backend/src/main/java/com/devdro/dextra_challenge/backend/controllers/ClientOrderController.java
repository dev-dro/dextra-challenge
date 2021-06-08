package com.devdro.dextra_challenge.backend.controllers;

import com.devdro.dextra_challenge.backend.model.ClientOrder;
import com.devdro.dextra_challenge.backend.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client-order")
public class ClientOrderController extends BaseController<ClientOrder> {

    @Override
    protected BaseService<ClientOrder> getService() {
        return null;
    }
}
