package com.ensapay.core.dao;

import com.ensapay.core.entities.Client;
import com.ensapay.core.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DemandeRepository extends MongoRepository<Demande,String> {
    List<Demande> findByResolu(boolean b);
}
