package com.ensapay.core.dao;

import com.ensapay.core.entities.Agent;
import com.ensapay.core.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,String> {
}
