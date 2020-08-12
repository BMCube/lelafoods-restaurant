package edu.miu.lelafoods.restaurant.service.impl;


import edu.miu.lelafoods.restaurant.dto.CartDTO;
import edu.miu.lelafoods.restaurant.service.RabbitMQSenderService;
import edu.miu.lelafoods.restaurant.utils.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Autowired
    ApplicationProperties applicationProperties;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void SendCartToDelivery(CartDTO cartDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(cartDTO, headers);
        ResponseEntity<Object> response = restTemplate.exchange(applicationProperties.getEmailUrl(), HttpMethod.POST, entity, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Email sent successfully:  " + response.getBody());
        } else {
            System.err.println("Email sent failed please try again");
        }

    }
}
