package com.example.util;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //允许使用socketJs方式访问，访问点为hello，允许跨域
        stompEndpointRegistry.addEndpoint("/hello").setAllowedOrigins("*").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //订阅Broker名称
        registry.enableSimpleBroker("/topic","/user");
        //全局使用的订阅前缀（客户端订阅路径上会体现出来）
        registry.setApplicationDestinationPrefixes("/app/");
        //点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        //registry.setUserDestinationPrefix("/user/");
    }

}
