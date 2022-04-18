package com.FiendStar.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FiendStar.Config.WebSocketConfig;
import com.FiendStar.Controller.model.Message;
import lombok.*;
/**
 * @author gurms
 * What we doin:
 *	stomp is a JS-api joins client(reactjs) and backend(spring)

	A LONG LIVED TCP CONNECTION is formed
 */
@Controller
public class ChatController {
	//methods to recieve the data or message from chatroom and then send it to the specific chatroom topic
	
	@Autowired
	private SimpMessagingTemplate sMTemplate;
	
	//websocket 
	//whenever a message object is sent to this mapping then it is sent to the /chatroom/public topic
	@MessageMapping("/message")	//	/app/public-message
	@SendTo("/chatroom/public")
	public Message recievePublicMessage(@Payload Message message) {			//	https://dzone.com/articles/mulesoft-payload-annotation-usage-in-java-componen
		return message;
	}
	
	@MessageMapping("/private-message")
	public Message recievePrivateMessage(@Payload Message message) {
		//here we have not specified the user topic so we'll create topic dynamically for the users to do that we'll use simpMesagingTemplate
		sMTemplate.convertAndSendToUser(message.getRecieverName(), "/private", message);		//		/user/dynamicusername/private
		
		return message;
	}
	
	

	
}