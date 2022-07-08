package com.gausslab.gserver.repository;

import com.gausslab.gserver.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String>
{
    List<ChatMessage> findChatMessagesBySendTimestampAfter(long startTimestamp);
}
