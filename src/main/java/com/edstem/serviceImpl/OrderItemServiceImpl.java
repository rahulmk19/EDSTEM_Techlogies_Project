package com.edstem.serviceImpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.edstem.model.MenuItem;
import com.edstem.model.OrderItem;
import com.edstem.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Override
	public OrderItem calculateSubTotalAmount(OrderItem orderItem, MenuItem menuItem) {
		orderItem.setSubTotal(menuItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
		return orderItem;
	}

}
