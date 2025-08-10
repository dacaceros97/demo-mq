package com.demo.rabbit_mq.demo_mq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.demo.rabbit_mq.demo_mq.config.RabbitMQConfig;

@Service
public class MessageProducer {

	private final RabbitTemplate rabbitTemplate;

	public MessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) {
		System.out.println("Enviando mensaje: " + message);
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
	}
}
