package com.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guestbook.model.GuestReply;

@Repository
public interface GuestReplyRepository extends JpaRepository<GuestReply, Long >{

}
