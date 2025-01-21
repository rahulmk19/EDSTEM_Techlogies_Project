package com.edstem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edstem.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	Optional<MenuItem> findByName(String name);

}
