package com.ensapay.core.dao;

import com.ensapay.core.entities.Client;
import com.ensapay.core.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DemandeRepository extends MongoRepository<Demande,String> {
}
