package com.ltimindtree.KafkaProject.Consumer;

import com.ltimindtree.KafkaProject.Model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    public static final String TOPIC_NAME = "MyTopic";
    public static final String GROUP_ID = "group_id";
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consume(Customer data){
        LOGGER.info(String.format("Message received -> %s", data.toString()));
    }

}
