package com.guestbook.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Entity
@XmlRootElement
public class Guest {
	
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
	
	@OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    public final Set<GuestReply> guestReplies = new HashSet<GuestReply>();
	
	
	public Set<GuestReply> getGuestReply() {
	        return Collections.unmodifiableSet(this.guestReplies);
	}

	/*public void addGuestReply(GuestReply guestReply) {
		 guestReply.setGuest(this);
	     this.guestReplies.add(guestReply);
	}*/
	
	public Guest(String name, String email, String comment){
		
		Assert.hasText(name, "Name must not be null or empty!");
		Assert.hasText(comment, "Comment must not be null or empty!");
		
		this.setName(name);
		this.setEmail(email);
		this.setComment(comment);
		this.date = LocalDateTime.now();
	}
	
	//public List<GuestReply> getGuestReply() {
	//	return guestReply;
	//}

	//public void setGuestReply(List<GuestReply> guestReply) {
	//	this.guestReply = guestReply;
	//}

	@SuppressWarnings("unused")
	public Guest() {
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
