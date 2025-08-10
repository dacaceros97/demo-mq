package com.demo.rabbit_mq.demo_mq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rabbit_mq.demo_mq.producer.MessageProducer;

@RestController
public class MessageController {

	private final MessageProducer messageProducer;

	public MessageController(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam String message) {
		messageProducer.sendMessage(message);
		return ResponseEntity.ok("Mensaje enviado exitosamente a RabbitMQ: " + message);
	}
}