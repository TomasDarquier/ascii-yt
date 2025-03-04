package com.tdarquier.asciiyt.configuration;

import com.tdarquier.asciiyt.handlers.VideoStreamHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new VideoStreamHandler(), "/stream").setAllowedOrigins("*");
    }
}
