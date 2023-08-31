package com.ltimindtree.KafkaProject.Controller;

import com.ltimindtree.KafkaProject.Model.Customer;
import com.ltimindtree.KafkaProject.Producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Customer customer){
        kafkaProducer.sendMessage(customer);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}
