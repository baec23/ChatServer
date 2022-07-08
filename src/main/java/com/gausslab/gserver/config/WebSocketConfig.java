package com.gausslab.gserver.config;

import com.gausslab.gserver.handler.SocketHandler;
import com.gausslab.gserver.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer
{
    private ChatMessageService chatMessageService;
    @Autowired
    private SocketHandler socketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
    {
        registry.addHandler(socketHandler, "/name");
    }

    @Bean
    public SocketHandler getSocketHandler(){
        return new SocketHandler(chatMessageService);
    }
}
