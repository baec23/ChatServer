package com.gausslab.chatserver.service;

import com.gausslab.chatserver.model.ChatMessage;
import com.gausslab.chatserver.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatMessageService
{
    private final ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getMessagesFromTime(int secondsAgo)
    {
        long startTimestamp = System.currentTimeMillis() - (secondsAgo * 1000L);
        return chatMessageRepository.findChatMessagesBySendTimestampAfter(startTimestamp);
    }

    public ChatMessage saveMessage(ChatMessage toSave)
    {
        return chatMessageRepository.save(toSave);
    }
}
