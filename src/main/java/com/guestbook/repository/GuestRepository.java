package com.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.model.Guest;




@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
	
	//@Query("select g from Guest g LEFT JOIN FETCH g.guestReplies")
    //List<GuestReply> findAllGuests();

}
