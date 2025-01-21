package com.edstem.service;

import com.edstem.model.MenuItem;
import com.edstem.model.OrderItem;

public interface OrderItemService {

	OrderItem calculateSubTotalAmount(OrderItem orderItem, MenuItem menuItem);

}
