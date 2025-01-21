package com.edstem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edstem.model.MenuItem;
import com.edstem.service.MenuItemService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/items")
@Slf4j
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@PostMapping
	public ResponseEntity<MenuItem> addMenuItem(@Valid @RequestBody MenuItem menuItem) {
		log.info("Request to add menu item : {}", menuItem);
		MenuItem item = menuItemService.createItem(menuItem);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getItemById(@PathVariable Integer id) {
		log.info("Request to get item : {}", id);
		MenuItem item = menuItemService.getItemById(id);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<MenuItem> updateMenuItem(@Valid @RequestBody MenuItem menuItem) {
		log.info("Request to update menu item : {}", menuItem);
		MenuItem item = menuItemService.updateItem(menuItem);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<MenuItem>> getAllItems() {
		log.info("Request to Get All menu item : {}");
		List<MenuItem> item = menuItemService.getAllItem();
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
		log.info("Request to delete item : {}", id);
		String deletedItem = menuItemService.deleteItem(id);
		return new ResponseEntity<>(deletedItem, HttpStatus.OK);
	}
}
