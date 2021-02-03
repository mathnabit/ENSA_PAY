package com.ensapay.core.dao;

import com.ensapay.core.entities.Client;
import com.ensapay.core.entities.ClientBanque;
import com.ensapay.core.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientBanqueRepository extends MongoRepository<ClientBanque,String> {
    ClientBanque findByTel(String tel);
}
