package com.intern.simpledata;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Location {
	
	@Id
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
}