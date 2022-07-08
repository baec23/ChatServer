package com.gausslab.chatserver.controller;

import com.gausslab.chatserver.model.ChatMessage;
import com.gausslab.chatserver.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatMessageController
{
    private final ChatMessageService chatMessageService;

    @GetMapping("/recentMessages")
    public ResponseEntity<List<ChatMessage>> getRecentWords()
    {
        return ResponseEntity.ok().body(chatMessageService.getMessagesFromTime(300));
    }

    @PostMapping("/chatMessage")
    public ResponseEntity<ChatMessage> saveChatMessage(@RequestBody ChatMessage toSave)
    {
        return ResponseEntity.accepted().body(chatMessageService.saveMessage(toSave));
    }
}
