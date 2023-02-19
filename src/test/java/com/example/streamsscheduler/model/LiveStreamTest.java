package com.example.streamsscheduler.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LiveStreamTest {
    @Test
    void create_new_mutable_live_stream(){
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring boot");
        stream.setDescription("""
                Spring Boot is very convineinet tool to use  when building Rest APIs""");
        stream.setUrl("https://docs.oracle.com/");
        stream.setStartDate(LocalDateTime.of(2022,2,16,11,50,16));
        stream.setEndDate(LocalDateTime.of(2022,2,17,11,50,16));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring boot", stream.getTitle(), "works");

    }

    @Test
    void create_new_immutable_live_stream(){
        ImmutableLiveStream stream = new ImmutableLiveStream(
        UUID.randomUUID().toString(),
        "Building REST APIs with Spring boot",
        """
                Spring Boot is very convineinet tool to use  when building Rest 
                APIs""",
        "https://docs.oracle.com/",
        LocalDateTime.of(2022,2,16,11,50,16),
        LocalDateTime.of(2022,2,17,11,50,16));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring boot", stream.getTitle(), "works");

    }


    @Test
    void create_new_record_live_stream(){
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring boot",
                """
                        Spring Boot is very convineinet tool to use  when building Rest 
                        APIs""",
                "https://docs.oracle.com/",
                LocalDateTime.of(2022,2,16,11,50,16),
                LocalDateTime.of(2022,2,17,11,50,16));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring boot", stream.title(), "works");
        assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);
    }



}
