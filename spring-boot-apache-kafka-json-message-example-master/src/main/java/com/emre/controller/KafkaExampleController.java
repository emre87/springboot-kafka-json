package com.emre.controller;

import com.emre.model.User;
import com.emre.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka/")
public class KafkaExampleController {

    @Autowired
    KafkaProducerService kafkaProducer;


    @PostMapping("/producer")
    public String sendMessage(@RequestBody User user)
    {
        kafkaProducer.send(user);
        return "Message sent successfully to the Kafka topic emre-topic";
    }

}
