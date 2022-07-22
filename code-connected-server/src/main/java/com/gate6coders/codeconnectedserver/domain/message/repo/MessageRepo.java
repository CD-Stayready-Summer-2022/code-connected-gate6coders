package com.gate6coders.codeconnectedserver.domain.message.repo;

import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Iterable<Message> findBySender(Long profileId);
    Iterable<Message> findByReceiver(Long profileId);
    Iterable<Message> findByDateSent(Timestamp timestamp);
}
