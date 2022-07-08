package com.gausslab.gserver;

import com.gausslab.gserver.model.SensorData;
import com.gausslab.gserver.repository.SensorDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GserverApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(GserverApplication.class, args);
    }

	@Bean
	CommandLineRunner runner(SensorDataRepository sensorDataRepository)
	{
		return args -> {
			SensorData sensorData = new SensorData(1, System.currentTimeMillis(), "0.4152");
			sensorDataRepository.insert(sensorData);
		};
	}

}
