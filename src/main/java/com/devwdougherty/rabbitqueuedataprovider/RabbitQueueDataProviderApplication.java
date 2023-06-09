package com.devwdougherty.rabbitqueuedataprovider;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RabbitQueueDataProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitQueueDataProviderApplication.class, args);
	}
}
