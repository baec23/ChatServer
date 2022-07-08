package com.gausslab.chatserver.handler;

import com.gausslab.chatserver.model.ChatMessage;
import com.gausslab.chatserver.service.ChatMessageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler
{
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ChatMessageService chatMessageService;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        ChatMessage toSave = gson.fromJson(message.getPayload(), ChatMessage.class);
        chatMessageService.saveMessage(toSave);

        for(WebSocketSession sess : sessions)
        {
            if(sess.isOpen())
                sess.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception
    {
        sessions.add(session);
    }
}
