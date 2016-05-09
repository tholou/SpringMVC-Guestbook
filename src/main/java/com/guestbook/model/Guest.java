package com.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Entity
public class Guest {
	
	@Id
    @GeneratedValue
    Long id;
	@NotBlank
	private String name;
	@Email
	private String email;
	@NotBlank
	private String comment;
	
	/*public Guest(String name, String email, String comment){
		
		Assert.hasText(name, "Name must not be null or empty!");
		Assert.hasText(comment, "Comment must not be null or empty!");
		
		this.setName(name);
		this.setEmail(email);
		this.setComment(comment);
		
		
		
	}
*/	
	public Long getId() {
		return id;
	}

	//@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//@NotBlank
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
