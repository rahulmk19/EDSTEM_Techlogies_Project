package com.edstem.service;

import com.edstem.model.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order getOrderById(Integer id);

}
