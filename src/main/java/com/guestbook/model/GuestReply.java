package com.guestbook.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Entity
@XmlRootElement
public class GuestReply {
	
	@Id
    @GeneratedValue
    Long id;
	@NotBlank
	private String name;
	@Email(message = "Invalid email address")
	private String email;
	@NotBlank
	private String comment;
	private LocalDateTime date;
	@ManyToOne
	Guest guest;
	
	public GuestReply(String name, String email, String comment){
		
		Assert.hasText(name, "Name must not be null or empty!");
		Assert.hasText(comment, "Comment must not be null or empty!");
		
		this.setName(name);
		this.setEmail(email);
		this.setComment(comment);
		this.date = LocalDateTime.now();
		
		
		
	}
	
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	@SuppressWarnings("unused")
	public GuestReply() {
		this.name = null;
		this.email = null;
		this.comment = null;
		this.date = null;
	}
	
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
	
	public LocalDateTime getDate() {
		return date;
	}

	//@NotBlank
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	



}
