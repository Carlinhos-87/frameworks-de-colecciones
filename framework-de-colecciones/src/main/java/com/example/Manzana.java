package com.example;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record Manzana(
		String variedad,
		BigDecimal precio,
		double peso
		) {
	
}