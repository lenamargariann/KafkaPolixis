package com.polixis.kafka.kafkapolixis.service;

import com.polixis.kafka.kafkapolixis.dao.KafkaMessagesDao;
import com.polixis.kafka.kafkapolixis.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagesService {
    private final KafkaMessagesDao kafkaMessagesDao;

    public List<KafkaMessage> getAllMessages() {
        return kafkaMessagesDao.getAllMessages();
    }

}
