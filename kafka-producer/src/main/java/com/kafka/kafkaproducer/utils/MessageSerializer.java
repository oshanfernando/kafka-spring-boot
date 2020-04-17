package com.kafka.kafkaproducer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.kafkaproducer.model.Message;
import org.apache.kafka.common.serialization.Serializer;


public class MessageSerializer implements Serializer<Message> {

    @Override
    public byte[] serialize(String topic, Message data) {
        byte[] serializedValue = null;
        ObjectMapper om = new ObjectMapper();
        if(data != null) {
            try {
                serializedValue = om.writeValueAsString(data).getBytes();
            } catch (JsonProcessingException e) {

            }
        }

        return serializedValue;
    }
}
