package edu.miu.lelafoods.restaurant.service.impl;

import edu.miu.lelafoods.restaurant.dto.CartDto;
import edu.miu.lelafoods.restaurant.service.RabbitMQReceiverService;
import edu.miu.lelafoods.restaurant.service.RabbitMQSenderService;
import edu.miu.lelafoods.restaurant.utils.ApplicationProperties;
import edu.miu.lelafoods.restaurant.utils.Utility;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    private AmqpTemplate amqpTemplate;


    private Utility utility = new Utility();

    @Override
    @RabbitListener(queues = "lelafoods-eai.queue")
    public void receiveCart(CartDto cartDto) {
        try {
            System.out.println("Recieved Message From RabbitMQ: " + cartDto.toString());
            System.out.println("Json from RabbitMQ: " + utility.cartToJson(cartDto));
            //received the the dto and save on queue to be sent for the delivery
            rabbitMQSenderService.saveQueueCart(cartDto);
            cartDto.setStatus("Restaurant received");
            rabbitMQSenderService.sendCartEmail(cartDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CartDto getSaveQueueCart() {
        CartDto cartDto= (CartDto) amqpTemplate.receiveAndConvert(applicationProperties.getSaveCartQueueName());
        System.out.println("getSaveQueueCart "+cartDto );
        return cartDto;
    }
}
