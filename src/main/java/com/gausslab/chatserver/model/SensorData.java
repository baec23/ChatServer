package com.gausslab.chatserver.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SensorData
{
    @Id
    private String id;
    private long sensorId;
    @Indexed
    private long entryTimestamp;
    private String data;

    public SensorData(long sensorId, long entryTimestamp, String data)
    {
        this.sensorId = sensorId;
        this.entryTimestamp = entryTimestamp;
        this.data = data;
    }
}
