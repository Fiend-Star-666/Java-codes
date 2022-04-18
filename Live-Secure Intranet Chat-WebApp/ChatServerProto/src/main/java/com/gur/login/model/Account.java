package com.gur.login.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
/**
 * @implNote: implementation of Account Objects for clients
 * @author gurms
 *
 */
@Entity
@Getter
@Setter
public class Account {
	@Id
	private String uid;
	private String name;
	private String pword;
	
	@Override
	public String toString() {
		return "Account [uid=" + uid + ", name=" + name + "]";
	}
	
}