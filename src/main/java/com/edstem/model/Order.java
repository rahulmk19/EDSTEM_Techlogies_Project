package com.edstem.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.edstem.enums.StatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal totalAmount;

	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@NotBlank
	@Size(min = 4, max = 30, message = "Customer name should be greater than equal to 4")
	private String customerName;

	@NotBlank
	@Size(min = 10, max = 10, message = "Phone number should be 10 digit number")
	private String customerPhone;

	private LocalDateTime createdAt;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderItem> items;

}
