package com.devdro.dextra_challenge.backend.repositories;

import com.devdro.dextra_challenge.backend.model.ClientOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends NamedEntityRepository<ClientOrder> {
}
