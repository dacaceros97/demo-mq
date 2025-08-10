package com.demo.rabbit_mq.demo_mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.demo.rabbit_mq.demo_mq.config.RabbitMQConfig;

@Component
public class MessageConsumer {

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void receiveMessage(String message) {
		System.out.println("Mensaje recibido: " + message);
	}
}
