package com.example.bmcommand.service.impl;

import com.example.bmcommand.config.RabbitMQConfig;
import com.example.bmcommand.service.BrokerService;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;


@Service
public class RabbitMQService implements BrokerService {
    private final RabbitTemplate rabbitTemplate;

    private final RabbitMQConfig rabbitMQTopicConfig;

    public RabbitMQService(RabbitTemplate rabbitTemplate, RabbitMQConfig rabbitMQTopicConfig){
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQTopicConfig = rabbitMQTopicConfig;
    }

    @Override
    public void send(String type, Object data) {
        String routingKey = type + ".#";
        rabbitTemplate.convertAndSend(rabbitMQTopicConfig.exchangeName, routingKey, data);
    }
}
