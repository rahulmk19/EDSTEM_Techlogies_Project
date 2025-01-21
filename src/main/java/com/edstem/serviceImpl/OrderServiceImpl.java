package com.edstem.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstem.exception.OrderException;
import com.edstem.model.MenuItem;
import com.edstem.model.Order;
import com.edstem.model.OrderItem;
import com.edstem.repository.MenuItemRepository;
import com.edstem.repository.OrderItemRepository;
import com.edstem.repository.OrderRepository;
import com.edstem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MenuItemServiceImpl menuItemServiceImpl;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Order createOrder(Order order) {
		
		BigDecimal toal= BigDecimal.ZERO;
		
//		for(OrderItem orderItem : order.getItems()) {
//			MenuItem menuItem= menuItemServiceImpl.getItemById(orderItem.getMenuItem().getId());
//			
//			orderItem=menuItemServiceImpl.c
//		}
		return null;
		
		
	}

	@Override
	public Order getOrderById(Integer id) {

		return orderRepository.findById(id).orElseThrow(() -> new OrderException("Order not found with id:" + id));
	}

}
