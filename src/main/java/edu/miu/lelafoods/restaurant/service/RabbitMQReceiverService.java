package edu.miu.restaurant.restaurant.service;

import edu.miu.restaurant.domain.Order;
import edu.miu.lelafoods.eai.domain.Cart;

public interface RabbitMQReceiverService {
	public void receiverOrder(Order order);
	public void SendOrderToDelivery( Order order);
}