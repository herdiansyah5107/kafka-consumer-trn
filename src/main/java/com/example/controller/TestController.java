package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component

public class TestController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    //Materi Traning
    @KafkaListener(topics = "MyTopic",
                   groupId = "group_id")
    // Method
    public void
    consume(String message)
    {
        // Print statement
        System.out.println("message = " + message);
    }
// ===============================================================================
// ===============================================================================
// ===============================================================================
// ===============================================================================
//Exercise Day 5
 //untuk menerima dari producer
@KafkaListener(topics = "ping-request",groupId = "group_id2")
public void consumePing (String messagePing){
// Print statement
System.out.println("message = " + messagePing);
// Untuk mengirim ke producer
kafkaTemplate.send("pong-request", "pong");
}

}
