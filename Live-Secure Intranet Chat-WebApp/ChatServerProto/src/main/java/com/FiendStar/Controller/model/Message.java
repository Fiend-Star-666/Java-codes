package com.FiendStar.Controller.model;
/**
 * @ImplNote: here a message object is made 
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
	private String senderName;
	private String recieverName;
	private String message;
	//private String date;
	private Status status;
}
