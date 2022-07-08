package com.gausslab.chatserver.repository;

import com.gausslab.chatserver.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorDataRepository extends MongoRepository<SensorData, String>
{

}
