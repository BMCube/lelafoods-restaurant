package edu.miu.lelafoods.restaurant.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.miu.lelafoods.restaurant.dto.CartDTO;
import edu.miu.lelafoods.restaurant.service.RabbitMQReceiverService;
import edu.miu.lelafoods.restaurant.service.RabbitMQSenderService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    Queue queue;

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    @Override
 //   @RabbitListener(queues = "lelafoods-eai.rabbitmq.queue")
    public void receiveCart(CartDTO cartDTO) {
//        try {
//            List<Order> orderList = cartDTO.getOrderList();
//            //  Cart cartToBeSent = new Cart();
//            double totalPrice;
//            for (Order order : orderList) {
//                //This part should contain same name with the cart model
//                totalPrice = order.getFood().getPrice() * order.getOrderQuantity();
//                BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
//                double newTotalPrice = bd.doubleValue();
//                order.getFood().setTotal(newTotalPrice);
//            }
//            //New cart object creation from the received message
//            //  cartToBeSent.setOrderList(orderList);
//            String cartJson = cartToJson(cart);
//            System.out.println("Recieved Message From RabbitMQ: " + cart.toString());
//            rabbitMQSenderService.sendCartToRestaurant(cart);
//            //    rabbitMQSenderService.sendCartEmail(cartJson);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public String cartToJson(CartDTO cartDTO) {
        ObjectMapper mapper = new ObjectMapper();
        String cartJson = "";
        try {
            cartJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartDTO);
            System.out.println("Json to be sent: " + cartJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartJson;
    }


}
