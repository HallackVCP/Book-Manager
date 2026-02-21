package com.example.bmcommand.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public final String exchangeName = "bookManagerExchange";

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue bookQueue(){
        return new Queue("bookQueue",true);
    }

    @Bean
    public Binding bindingBook(Queue bookQueue, TopicExchange exchange){
        return BindingBuilder.bind(bookQueue).to(exchange).with("book.#");
    }

    @Bean
    public Queue reviewQueue(){
        return new Queue("reviewQueue",true);
    }

    @Bean
    public Binding bindingReview(Queue reviewQueue, TopicExchange exchange){
        return BindingBuilder.bind(reviewQueue).to(exchange).with("review.#");
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

}
