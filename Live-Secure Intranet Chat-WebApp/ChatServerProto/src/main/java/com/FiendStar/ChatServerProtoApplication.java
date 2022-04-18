package com.FiendStar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.gur.login.LoginApplication;
/**
 * 
 * @author gurms
 * @implNote This is where two Modules are interconnected using @ import annotation
 */
@SpringBootApplication
@Import(LoginApplication.class)
@ComponentScan
@EnableAutoConfiguration
public class ChatServerProtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatServerProtoApplication.class, args);
	}

}


/**
 * 	to kill the application running at specific port
 * 		cmd
 * 		netstat -ano | findstr :8080	//example
 * 		taskkill /PID id
 */
