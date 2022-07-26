package com.gate6coders.codeconnectedserver.domain.message.model;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageContent;

    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_message_id", referencedColumnName = "id")
    private Profile sender;

    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_message_id", referencedColumnName = "id")
    private Profile receiver;

    private Timestamp dateSent;

    public Message(String messageContent, Profile sender, Profile receiver, Timestamp dateSent) {
        this.messageContent = messageContent;
        this.sender = sender;
        this.receiver = receiver;
        this.dateSent = dateSent;
    }
}
