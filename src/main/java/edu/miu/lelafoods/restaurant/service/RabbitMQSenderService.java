package edu.miu.lelafoods.restaurant.service;


import edu.miu.lelafoods.restaurant.dto.CartDto;

public interface RabbitMQSenderService {
	public void saveQueueCart(CartDto cartDto);
	public void sendCartEmail(CartDto cartDto);
	public void sendDeliveryQueueCart(CartDto cartDto);
}