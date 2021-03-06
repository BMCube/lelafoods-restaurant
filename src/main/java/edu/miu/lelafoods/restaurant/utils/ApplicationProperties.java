package edu.miu.lelafoods.restaurant.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${lelafoods-delivery.rabbitmq.queue}")
    private String deliveryQueueName;

    @Value("${lelafoods-delivery.rabbitmq.routingkey}")
    private String deliveryRoutingkey;

    @Value("${lelafoods-order.rabbitmq.exchange}")
    private String exchange;

    @Value("${lelafoods-eai.rabbitmq.queue}")
    private String eaiQueueName;

    @Value("${lelafoods-restaurant.rabbitmq.exchange}")
    private String restaurantExchange;

    @Value("${lelafoods-eai.rabbitmq.routingkey}")
    private String eaiRoutingkey;

    @Value("${email.url}")
    private String emailUrl;

    @Value("${lelafoods-save-cart.rabbitmq.routingkey}")
    private String saveCartRoutingkey;

    @Value("${lelafoods-save-cart.rabbitmq.queue}")
    private String saveCartQueueName;

    public String getExchange() {
        return exchange;
    }

    public String getEaiQueueName() {
        return eaiQueueName;
    }

    public String getEaiRoutingkey() {return eaiRoutingkey;}

    public String getDeliveryQueueName() {
        return deliveryQueueName;
    }

    public String getDeliveryRoutingkey() {
        return deliveryRoutingkey;
    }

    public String getRestaurantExchange() {
        return restaurantExchange;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public String getSaveCartRoutingkey() {
        return saveCartRoutingkey;
    }

    public String getSaveCartQueueName() {
        return saveCartQueueName;
    }

}
