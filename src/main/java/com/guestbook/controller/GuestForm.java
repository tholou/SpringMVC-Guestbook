package com.guestbook.controller;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

interface GuestForm {
	
	@NotBlank
	String getName();

	@NotBlank
	String getComment();
	
	@Email(message = "Invalid email address")
	String getEmail();

}
