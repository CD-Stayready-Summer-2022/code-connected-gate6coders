package com.gate6coders.codeconnectedserver.domain.aboutUser.model;
import com.gate6coders.codeconnectedserver.domain.education.model.Education;
import com.gate6coders.codeconnectedserver.domain.experience.model.Experience;
import com.gate6coders.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AboutUserModelTest {

    private AboutUser aboutUser1;

    private AboutUser aboutUser2;

    private Profile profile1;

    private AboutUser emptyDescription1;

    private AboutUser emptyDescription2;

    private AboutUser description1;

    private AboutUser description2;

    @BeforeEach
    public void setup(){
        emptyDescription1 = new AboutUser();

        emptyDescription2 = new AboutUser();

        description1 = new AboutUser();

        description2 = new AboutUser();

        profile1 = new Profile();

        aboutUser1 = new AboutUser("This is dummy", "Dummy Headline", List<String>, List<Experience>, List<Education>);

        aboutUser2 = new AboutUser("This is dummy", "Dummy Headline", List<String>, List<Experience>, List<Education>);

        aboutUser1.setId(1L);
    }

    @Test
    public void testEmptyDescriptionEquals(){
        Assertions.assertEquals(emptyDescription1, emptyDescription2);
    }

    @Test
    public void testNotEmptyDescriptionEquals(){
        Assertions.assertNotEquals(description1, description2);
    }

    @Test
    public void testAboutUserNotEmptyEquals(){
        Assertions.assertEquals(aboutUser1, aboutUser2);
    }
}