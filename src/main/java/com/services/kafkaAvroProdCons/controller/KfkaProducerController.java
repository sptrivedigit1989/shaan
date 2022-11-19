package com.services.kafkaAvroProdCons.controller;

import com.prepwork.kreadwritemsg.kafka.avro.model.Student;
import com.services.kafkaAvroProdCons.service.KfkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@Slf4j
public class KfkaProducerController {

    @Value("${avro.topic.name}")
    private String avroTopicName;

    @Autowired
    private KfkaProducerService producerService;

    @PostMapping("/createStudent")
    public String getDataForKafkaTopic(@RequestBody Student student){
        log.info("sending data.....to topicName-Value {}-{}",avroTopicName, student.toString());
        producerService.sendAvroData(avroTopicName, student);
        return "Data Posted";
    }


}
