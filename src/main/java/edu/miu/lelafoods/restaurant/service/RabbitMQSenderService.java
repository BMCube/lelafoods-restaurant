package edu.miu.lelafoods.restaurant.service;


import edu.miu.lelafoods.restaurant.dto.CartDTO;

public interface RabbitMQSenderService {
	public void SendCartToDelivery(CartDTO cartDTO);
}