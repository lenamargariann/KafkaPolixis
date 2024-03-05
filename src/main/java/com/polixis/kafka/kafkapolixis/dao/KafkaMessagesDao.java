package com.polixis.kafka.kafkapolixis.dao;

import com.polixis.kafka.kafkapolixis.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class KafkaMessagesDao {
    @Value("${spring.data.mongodb.collection.name}")
    private String collectionName;
    private final MongoTemplate template;

    public void save(KafkaMessage kafkaMessage) {
        template.insert(kafkaMessage, collectionName);
    }

    public List<KafkaMessage> getAllMessages() {
        List<KafkaMessage> all = template.findAll(KafkaMessage.class, collectionName);
        log.info("MESSAGES " + all);
        return all;
    }
}
