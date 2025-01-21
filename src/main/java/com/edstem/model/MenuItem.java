package com.edstem.model;

import java.math.BigDecimal;

import com.edstem.enums.CategoryEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MenuItem")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	@Min(value = 1, message = "Price should be in positive")
	private BigDecimal price;

	@NotBlank
	@Min(value = 0, message = "quantity should be in positive")
	private Integer quantity;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

}
