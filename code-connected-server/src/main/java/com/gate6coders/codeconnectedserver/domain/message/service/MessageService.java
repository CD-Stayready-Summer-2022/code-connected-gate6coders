package com.gate6coders.codeconnectedserver.domain.message.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    Iterable<Message> getBySender(Profile profile);
    Iterable<Message> getByReceiver(Profile profile);
    Boolean delete(Long id) throws ResourceNotFoundException;
}
