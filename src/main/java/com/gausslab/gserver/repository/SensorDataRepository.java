package com.gausslab.gserver.repository;

import com.gausslab.gserver.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorDataRepository extends MongoRepository<SensorData, String>
{

}
