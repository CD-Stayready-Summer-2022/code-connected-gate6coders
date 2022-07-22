package com.gate6coders.codeconnectedserver.domain.message.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import com.gate6coders.codeconnectedserver.domain.message.repo.MessageRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepo messageRepo;

    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public Message create(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message getById(Long id) throws ResourceNotFoundException {
        return messageRepo.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Iterable<Message> getBySender(Profile profile) {
        return null;
    }

    @Override
    public Iterable<Message> getByReceiver(Profile profile) {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        Message message = messageRepo.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        messageRepo.delete(message);
        return true;
    }
}
