package com.studiomediatech.messaging;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import java.util.function.Consumer;


public class RabbitUntilTemplate {

    private final SimpleMessageListenerContainer container;
    private final RabbitTemplate template;

    public RabbitUntilTemplate(SimpleMessageListenerContainer container, RabbitTemplate template) {

        this.container = container;
        this.template = template;
    }

    void sendAndReceiveUntil(Message message, Until until, Consumer<Message> handler) throws AmqpException {

        setup();
        // TODO
    }


    void sendAndReceiveUntil(String routingKey, Message message, Until until, Consumer<Message> handler)
        throws AmqpException {

        // TODO
    }


    void sendAndReceiveUntil(String exchange, String routingKey, Message message, Until until,
        Consumer<Message> handler) throws AmqpException {

        // TODO
    }


    private void setup() {
    	
    	Queue q = QueueBuilder.nonDurable().autoDelete().build();
    	
    	container.add
    	
    }
}
