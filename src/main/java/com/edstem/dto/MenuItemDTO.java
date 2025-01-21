package com.edstem.dto;

import java.math.BigDecimal;

import com.edstem.enums.CategoryEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MenuItemDTO {

	@NotBlank
	private String name;

	@NotBlank
	@Min(value = 1)
	private BigDecimal price;

	@NotBlank
	@Min(value = 0)
	private Integer quantity;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

}
