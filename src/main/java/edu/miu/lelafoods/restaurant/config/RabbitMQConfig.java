package edu.miu.lelafoods.restaurant.config;

import edu.miu.lelafoods.restaurant.utils.ApplicationProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Autowired
    ApplicationProperties applicationProperties;

    @Bean
    Queue queueEai() {
        return new Queue(applicationProperties.getEaiQueueName(), true);
    }

    @Bean
    Queue queueSave() {
        return new Queue(applicationProperties.getSaveCartQueueName(), true);
    }

    @Bean
    Queue queueDelivery() {
        return new Queue(applicationProperties.getDeliveryQueueName(), true);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(applicationProperties.getExchange());
    }

    @Bean
    DirectExchange exchangeDelivery() {
        return new DirectExchange(applicationProperties.getRestaurantExchange());
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queueDelivery()).to(exchangeDelivery()).with(applicationProperties.getDeliveryRoutingkey());
    }
    @Bean
    Binding bindingSave() {
        return BindingBuilder.bind(queueSave()).to(exchangeDelivery()).with(applicationProperties.getSaveCartRoutingkey());
    }
    @Bean
    Binding bindingEai() {
        return BindingBuilder.bind(queueEai()).to(exchange()).with(applicationProperties.getEaiRoutingkey());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
