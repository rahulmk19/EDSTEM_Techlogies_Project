package com.edstem.service;

import java.util.List;

import com.edstem.model.MenuItem;

public interface MenuItemService {

	MenuItem createItem(MenuItem menuItem);

	MenuItem updateItem(MenuItem menuItem);

	MenuItem getItemById(Integer id);

	String deleteItem(Integer id);

	List<MenuItem> getAllItem();

}
