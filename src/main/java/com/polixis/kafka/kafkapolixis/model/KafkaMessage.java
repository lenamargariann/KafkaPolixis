package com.polixis.kafka.kafkapolixis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "kafkaMessages")
public class KafkaMessage {
    @MongoId
    @JsonIgnore
    private String id;
    @Field(name = "message")
    private String message;

    public KafkaMessage() {
    }

    public KafkaMessage(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
