package com.edstem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstem.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
