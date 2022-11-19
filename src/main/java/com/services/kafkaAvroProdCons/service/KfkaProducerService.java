package com.services.kafkaAvroProdCons.service;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KfkaProducerService {

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void sendAvroData(String topicName, Student student) {
        log.info("sending data to kafka topic i.e. {}", topicName);
        String key = "Key" + String.format("%.3f", Math.random());
        kafkaTemplate.send(topicName, key, student);
        log.info("Sent message successfully {} ", student.toString());
    }

}
