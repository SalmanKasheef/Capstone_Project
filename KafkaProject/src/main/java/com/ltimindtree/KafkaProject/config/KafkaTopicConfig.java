package com.ltimindtree.KafkaProject.config;
//First
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic KafkaTopic(){
        return TopicBuilder.name("KafkaProject")
                .build();
    }
}
