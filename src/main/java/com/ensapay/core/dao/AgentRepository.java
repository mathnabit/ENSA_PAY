package com.ensapay.core.dao;

import com.ensapay.core.entities.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentRepository extends MongoRepository<Agent,String> {
}
