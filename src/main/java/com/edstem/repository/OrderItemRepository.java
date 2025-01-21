package com.edstem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstem.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
