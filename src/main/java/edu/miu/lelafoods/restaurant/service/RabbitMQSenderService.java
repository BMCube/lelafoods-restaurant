package edu.miu.lelafoods.restaurant.service;


import edu.miu.lelafoods.restaurant.dto.CartDto;

public interface RabbitMQSenderService {
	public void saveCart(CartDto cartDto);
	public void sendCartEmail(CartDto cartDto);
}