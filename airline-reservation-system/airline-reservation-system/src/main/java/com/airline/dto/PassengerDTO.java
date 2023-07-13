package com.airline.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PassengerDTO extends UserDTO{

	private String name;
	private String phone;
	private String email;
}
