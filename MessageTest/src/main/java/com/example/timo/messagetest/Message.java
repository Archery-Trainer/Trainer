package com.example.timo.messagetest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Message to be passed between Android client and server
 *
 */
public class Message {

    private final long id;
    private final MessageType type;
    private final String payload;

    public Message(@JsonProperty("id")long id,
                   @JsonProperty("type")MessageType type,
                   @JsonProperty("payload")String payload) {
        this.id = id;
        this.type = type;
        this.payload = payload;

        System.out.println("Created new message");
    }

    public long getId() {
        return id;
    }

    public MessageType getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }
}
