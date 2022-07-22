package com.gate6coders.codeconnectedserver.domain.message.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gate6coders.codeconnectedserver.aboutUser.model.AboutUser;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.message.model.Message;
import com.gate6coders.codeconnectedserver.domain.message.service.MessageService;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class MessageControllerTest {

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    private Message inputMessage;
    private Message mockResponseMessage1;
    private Message mockResponseMessage2;

    private Profile profile1;
    private Profile profile2;

    private AboutUser aboutUser;

    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        aboutUser = new AboutUser("D", "d", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        profile1 = new Profile("Luis", "Adorno", "fake@fakemail.com", "THELuis", "123", aboutUser);
        profile2 = new Profile("Luis", "Adorno", "fake@fakemail.com", "THELuis", "123", aboutUser);
        inputMessage = new Message("This is a dummy message.",
                profile1, profile2, Timestamp.valueOf(LocalDateTime.now()));
        mockResponseMessage1 = new Message("This is a dummy message.",
                profile1, profile2, Timestamp.valueOf(LocalDateTime.now()));
        mockResponseMessage1.setId(1L);
        mockResponseMessage2 = new Message("This is another dummy message.",
                profile1, profile2, Timestamp.valueOf(LocalDateTime.now()));
        mockResponseMessage2.setId(2L);
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Create message request - success")
    public void createMessageRequestTest01() throws Exception {
        BDDMockito.doReturn(mockResponseMessage1).when(messageService).create(ArgumentMatchers.any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(inputMessage)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    }

    @Test
    @DisplayName("Get message request - success")
    public void getMessageRequestTest01() throws Exception{
        BDDMockito.doReturn(mockResponseMessage1).when(messageService).getById(ArgumentMatchers.any());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/messages/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(inputMessage)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    }

    @Test
    @DisplayName("Get message request - failure")
    public void getMessageRequestTest02() throws Exception{
        BDDMockito.doThrow(new ResourceNotFoundException()).when(messageService).getById(ArgumentMatchers.any());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/messages/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Delete message request - success")
    public void deleteMessageRequestTest01() throws Exception{
        BDDMockito.doReturn(true).when(messageService).delete(ArgumentMatchers.any());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/messages/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @DisplayName("Delete message request - failure")
    public void deleteMessageRequestTest02() throws Exception{
        BDDMockito.doThrow(new ResourceNotFoundException()).when(messageService).delete(ArgumentMatchers.any());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/messages/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
