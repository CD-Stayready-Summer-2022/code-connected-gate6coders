package com.gate6coders.codeconnectedserver.domain.message.model;

import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MessageTest {

    private Message message1;
    private Message message2;

    private Profile profile1;
    private Profile profile2;

    private Message emptyMessage1;
    private Message emptyMessage2;

    @BeforeEach
    public void setUp() {
        emptyMessage1 = new Message();
        emptyMessage2 = new Message();

        profile1 = new Profile();
        profile2 = new Profile();

        message1 = new Message("This is a dummy message!", profile1,
                profile2, Timestamp.valueOf(LocalDateTime.now()));
        message2 = new Message("This is a dummy message!", profile2,
                profile1, Timestamp.valueOf(LocalDateTime.now()));
        message1.setId(1L);
        message1.setId(2L);
    }

    @Test
    public void testEmptyEquals(){
        Assertions.assertEquals(emptyMessage1, emptyMessage2);
    }

    @Test
    public void testNotEquals(){
        Assertions.assertNotEquals(message1, message2);
    }

    @Test
    public void testEmptyHashCode(){
        Assertions.assertEquals(emptyMessage1.hashCode(), emptyMessage2.hashCode());
    }

    @Test
    public void testHashCode(){
        Assertions.assertNotEquals(message1.hashCode(), message2.hashCode());
    }

    @Test
    public void testEmptyToString(){
        Assertions.assertEquals(emptyMessage1.toString(), emptyMessage2.toString());
    }

    @Test
    public void testToString(){
        Assertions.assertNotEquals(message1.toString(), message2.toString());
    }
}
