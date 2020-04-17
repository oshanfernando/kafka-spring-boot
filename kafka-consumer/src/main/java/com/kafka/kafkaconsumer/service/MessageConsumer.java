package com.kafka.kafkaconsumer.service;

import com.kafka.kafkaconsumer.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final String TOPIC = "message.topic";

    @KafkaListener(topics = TOPIC)
    public void messageListener(ConsumerRecord<String, Message> consumerRecord, Acknowledgment ack) {

        String key = consumerRecord.key();
        Message value = consumerRecord.value();
        int partition = consumerRecord.partition();

        System.out.println("Consumed message : " + value
                        + " with key : " + key
                        + " from partition : "+ partition);

        ack.acknowledge();
    }
}
