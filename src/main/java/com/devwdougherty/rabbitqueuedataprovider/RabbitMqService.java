package com.devwdougherty.rabbitqueuedataprovider;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class RabbitMqService {

    public void connectToRabbitMqBroker() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            factory.setPort(15672);
            factory.setUsername("guest");
            factory.setPassword("guest");

            channel.queueDeclare("positions_queue", false, false, false, null);
            String message = "position details";
            channel.basicPublish("", "positions_queue", null, message.getBytes());

            channel.close();
            connection.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
