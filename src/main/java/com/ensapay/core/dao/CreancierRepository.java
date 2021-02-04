package com.ensapay.core.dao;

import com.ensapay.core.entities.Creancier;
import com.ensapay.core.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreancierRepository extends MongoRepository<Creancier,String> {
}
