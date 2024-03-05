package com.polixis.kafka.kafkapolixis.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, String> template;

    public void send(String toSend) {
        log.info("Producer send: "+toSend);
        this.template.send("my-topic", toSend);
    }

    @SneakyThrows
    public void save(String kafkaMessage) {
        send(kafkaMessage);
    }


}
