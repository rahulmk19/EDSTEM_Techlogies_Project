package com.edstem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edstem.exception.MenuItemException;
import com.edstem.model.MenuItem;
import com.edstem.repository.MenuItemRepository;
import com.edstem.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public MenuItem createItem(MenuItem menuItem) {

		log.info("Creating Item: {} ", menuItem);
		Optional<MenuItem> isExits = menuItemRepository.findByName(menuItem.getName());
		if (isExits.isPresent()) {
			throw new MenuItemException("Item is exits with name: " + menuItem.getName());
		}
		return menuItemRepository.save(menuItem);

	}

	@Override
	public MenuItem getItemById(Integer id) {
		log.info("Getting Item by id: {} ", id);
		Optional<MenuItem> isExits = menuItemRepository.findById(id);
		if (!isExits.isPresent()) {
			throw new MenuItemException("Item is not exits with Id: " + id);
		}
		return isExits.get();
	}

	@Override
	public MenuItem updateItem(MenuItem menuItem) {

		log.info("Updating Item: {} ", menuItem);
		Optional<MenuItem> isExits = menuItemRepository.findById(menuItem.getId());
		if (!isExits.isPresent()) {
			throw new MenuItemException("Item is not exits with Id: " + menuItem.getId());
		}
		MenuItem newMenuItem = isExits.get();
		newMenuItem.setName(menuItem.getName());
		newMenuItem.setPrice(menuItem.getPrice());
		newMenuItem.setQuantity(menuItem.getQuantity());
		newMenuItem.setCategory(menuItem.getCategory());
		return menuItemRepository.save(newMenuItem);
	}

	@Override
	public String deleteItem(Integer id) {

		log.info("Deleting Item by id: {} ", id);
		Optional<MenuItem> isExits = menuItemRepository.findById(id);
		if (!isExits.isPresent()) {
			throw new MenuItemException("Item is not exits with Id: " + id);
		}
		menuItemRepository.delete(isExits.get());
		return "Item deleted sucessfully with id:" + id;
	}

	@Override
	public List<MenuItem> getAllItem() {
		log.info("Get All Item: {} ");
		List<MenuItem> allItem = menuItemRepository.findAll();

		return allItem;
	}

}
