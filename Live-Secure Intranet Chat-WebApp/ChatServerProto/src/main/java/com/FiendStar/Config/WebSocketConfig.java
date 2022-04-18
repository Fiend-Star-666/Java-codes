package com.FiendStar.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/**
 * @implNote Here the Topic prefixes are declared where the clients would subscribe too.
 * @author gurms
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry reg) {
		//here we will Declare the topics prefixes i.e. chatroom and user and the application prefix i.e. where the user will send the data
		reg.setApplicationDestinationPrefixes("/app");
		reg.enableSimpleBroker("/chatroom","/user");
		reg.setUserDestinationPrefix("/user");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry reg) {
		//originpatterns are related to CORS cross origin resource sharing: sharing between two websites
		//ws=websocket
		reg.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
	}
	
	
}