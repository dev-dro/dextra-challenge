package com.devdro.dextra_challenge.backend.services.jpa;

import com.devdro.dextra_challenge.backend.model.ClientOrder;
import com.devdro.dextra_challenge.backend.repositories.ClientOrderRepository;
import com.devdro.dextra_challenge.backend.services.ClientOrderService;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderJpaService extends NamedEntityJpaService<ClientOrder> implements ClientOrderService {

    private final ClientOrderRepository clientOrderRepository;

    public ClientOrderJpaService(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    @Override
    protected ClientOrderRepository getRepository() {
        return clientOrderRepository;
    }
}
