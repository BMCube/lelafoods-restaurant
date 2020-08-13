package edu.miu.lelafoods.restaurant.service.impl;


import edu.miu.lelafoods.restaurant.dto.CartDto;
import edu.miu.lelafoods.restaurant.service.RabbitMQSenderService;
import edu.miu.lelafoods.restaurant.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    private AmqpTemplate amqpTemplate;

    RestTemplate restTemplate = new RestTemplate();


    @Override
    public void saveCart(CartDto cartDto) {
        //Modify the cartDto and save it on queue save
        amqpTemplate.convertAndSend(applicationProperties.getRestaurantExchange(), applicationProperties.getSaveCartRoutingkey(), cartDto);
        System.out.println("saveCart = " + cartDto);
    }

    @Override
    public void sendCartEmail(CartDto cartDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //Modify the cartDto here to change the subject with relation to restaurant MS
        HttpEntity<?> entity = new HttpEntity<>(cartDto, headers);
        ResponseEntity<Object> response = restTemplate.exchange(applicationProperties.getEmailUrl(), HttpMethod.POST, entity, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Email sent successfully:  " + response.getBody());
        } else {
            System.err.println("Email sent failed please try again");
        }
    }


}
