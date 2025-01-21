package com.edstem.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstem.enums.StatusEnum;
import com.edstem.exception.OrderException;
import com.edstem.model.MenuItem;
import com.edstem.model.Order;
import com.edstem.model.OrderItem;
import com.edstem.repository.OrderRepository;
import com.edstem.service.MenuItemService;
import com.edstem.service.OrderItemService;
import com.edstem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private OrderItemService orderItemService;

	@Override
	public Order createOrder(Order order) {

		BigDecimal total = BigDecimal.ZERO;

		for (OrderItem item : order.getItems()) {
			MenuItem menuItem = menuItemService.getItemById(item.getMenuItem().getId());

			item = orderItemService.calculateSubTotalAmount(item, menuItem);
			menuItemService.updateItem(menuItem);
			total = total.add(item.getSubTotal());
		}

		order.setTotalAmount(total);
		order.setStatus(StatusEnum.RECEIVED);
		order.setCreatedAt(LocalDateTime.now());

		return orderRepository.save(order);

	}

	@Override
	public Order getOrderById(Integer id) {

		return orderRepository.findById(id).orElseThrow(() -> new OrderException("Order not found with id:" + id));
	}

}
