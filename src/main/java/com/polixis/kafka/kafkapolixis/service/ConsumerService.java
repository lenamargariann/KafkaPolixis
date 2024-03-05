package com.polixis.kafka.kafkapolixis.service;


import com.polixis.kafka.kafkapolixis.dao.KafkaMessagesDao;
import com.polixis.kafka.kafkapolixis.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    private final KafkaMessagesDao dao;

    @KafkaListener(topics = "my-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String in) {
        log.info("Consumer service: " + in);
        dao.save(new KafkaMessage(null, in));
    }
}
