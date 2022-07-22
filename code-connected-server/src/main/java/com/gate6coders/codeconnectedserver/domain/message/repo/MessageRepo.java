package com.gate6coders.codeconnectedserver.domain.message.repo;

import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Iterable<Message> findBySender(Profile profile);
    Iterable<Message> findByReceiver(Profile profile);
    Iterable<Message> findByDateSent(Timestamp timestamp);
}
