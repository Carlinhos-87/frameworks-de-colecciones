package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Persona(
		String nombre,
		String apellido1,
		String apellido2,
		Genero genero,
		LocalDate fechaNacimiento,
		BigDecimal salario) {
		
}
