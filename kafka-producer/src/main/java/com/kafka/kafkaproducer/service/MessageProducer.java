package com.kafka.kafkaproducer.service;

import com.kafka.kafkaproducer.model.Message;

public interface MessageProducer {
    void publishToQueue(String key, Message message);
}
