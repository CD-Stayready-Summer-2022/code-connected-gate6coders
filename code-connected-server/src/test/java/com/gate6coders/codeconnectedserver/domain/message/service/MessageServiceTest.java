package com.gate6coders.codeconnectedserver.domain.message.service;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import com.gate6coders.codeconnectedserver.domain.message.repo.MessageRepo;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @MockBean
    MessageRepo messageRepo;

    private Message mockMessage1;
    private Message savedMessage1;

    @BeforeEach
    public void setUp() {
        mockMessage1 = new Message("This is a message!",
                new Profile(), new Profile(), Timestamp.valueOf(LocalDateTime.now()));
        savedMessage1 = new Message("This is a message!",
                new Profile(), new Profile(), Timestamp.valueOf(LocalDateTime.now()));
        savedMessage1.setId(1L);
    }

    @Test
    @DisplayName("Create Person - success")
    public void createPersonTest01(){
        BDDMockito.doReturn(savedMessage1).when(messageRepo).save(mockMessage1);
        Message message = messageService.create(mockMessage1);
        Assertions.assertNotNull(message.getId());
    }

    @Test
    @DisplayName("Get by id - success")
    public void getByIdTest01(){
        BDDMockito.doReturn(Optional.of(savedMessage1)).when(messageRepo).findById(ArgumentMatchers.any());
        Message message = messageService.getById(1L);
        Assertions.assertNotNull(message);
    }

    @Test
    @DisplayName("Get by id - failure")
    public void getByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(ArgumentMatchers.any());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            messageService.getById(1L);
        });
    }

    @Test
    @DisplayName("Get messages by sender")
    public void getMessageBySenderTest01(){
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage1);
        BDDMockito.doReturn(messages).when(messageRepo).findBySender(ArgumentMatchers.any());
        Iterable<Message> messagesBySender = messageService.getBySender(1L);
        Assertions.assertTrue(messagesBySender.iterator().hasNext());
    }

    @Test
    @DisplayName("Get messages by receiver")
    public void getMessagesByReceiverTest01(){
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage1);
        BDDMockito.doReturn(messages).when(messageRepo).findByReceiver(ArgumentMatchers.any());
        Iterable<Message> messagesByReceiver = messageService.getByReceiver(1L);
        Assertions.assertTrue(messagesByReceiver.iterator().hasNext());
    }

    @Test
    @DisplayName("Get by date sent")
    public void getByDateSentTest01(){
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage1);
        BDDMockito.doReturn(messages).when(messageRepo).findByDateSent(ArgumentMatchers.any());
        Iterable<Message> messagesByDate = messageService.getByDate(Timestamp.valueOf(LocalDateTime.now()));
        Assertions.assertTrue(messagesByDate.iterator().hasNext());
    }

    @Test
    @DisplayName("Delete - success")
    public void deleteMessageTest01(){
        BDDMockito.doReturn(Optional.of(savedMessage1)).when(messageRepo).findById(ArgumentMatchers.any());
        Assertions.assertTrue(messageService.delete(1L));
    }

    @Test
    @DisplayName("Delete - failure")
    public void deleteMessage02(){
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(ArgumentMatchers.any());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            messageService.delete(1L);
        });
    }
}
