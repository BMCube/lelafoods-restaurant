package edu.miu.lelafoods.restaurant.service;

import edu.miu.lelafoods.restaurant.dto.CartDto;

public interface RabbitMQReceiverService {
	public void receiveCart(CartDto cartDto);
}