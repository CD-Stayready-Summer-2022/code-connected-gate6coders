package com.gate6coders.codeconnectedserver.domain.message.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.message.model.Message;

import java.sql.Timestamp;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getBySender(Long senderId) throws ResourceNotFoundException;
    Iterable<Message> getByReceiver(Long receiverId) throws ResourceNotFoundException;
    Iterable<Message> getByDate(Timestamp timestamp);
    Boolean delete(Long id) throws ResourceNotFoundException;
}
