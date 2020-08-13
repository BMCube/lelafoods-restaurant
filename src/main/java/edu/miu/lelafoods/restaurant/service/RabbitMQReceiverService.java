package edu.miu.lelafoods.restaurant.service;

import edu.miu.lelafoods.restaurant.dto.CartDTO;

public interface RabbitMQReceiverService {
	public void receiveCart(CartDTO cartDTO);
	public String cartToJson(CartDTO cartDTO);
}