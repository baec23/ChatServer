package com.gausslab.gserver.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ChatMessage
{
    private transient String id;
    private String senderName;
    private long sendTimestamp;
    private String messageContent;

    public ChatMessage(String senderName, long sendTimestamp, String messageContent)
    {
        this.senderName = senderName;
        this.sendTimestamp = sendTimestamp;
        this.messageContent = messageContent;
    }
}
