package com.kafka.kafkaconsumer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.kafkaconsumer.model.Message;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDeserializer implements Deserializer<Message> {
    @Override
    public Message deserialize(String topic, byte[] data) {

        Message message = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(data, Message.class);
        } catch (IOException e) {

        }

        return message;
    }
}
