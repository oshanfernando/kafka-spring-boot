package com.kafka.kafkaproducer.service;

import com.kafka.kafkaproducer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerImpl implements MessageProducer {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    private static final String TOPIC = "message.topic";

    @Override
    public void publishToQueue(String key, Message value) {
        kafkaTemplate.send(TOPIC, key, value);
    }
}
