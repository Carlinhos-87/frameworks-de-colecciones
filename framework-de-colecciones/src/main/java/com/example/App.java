package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;




public class App {

	public static void main(String[] args) {

		/*
		 * Operaciones de Agregado, para recorrer y operar con los elementos de una
		 * coleccion
		 * 
		 * En el siguiente enlace se hace una breve introduccion a las Operaciones de
		 * Agregado
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.
		 * html
		 * 
		 * Y en el link siguiente ya se abordan con mas profundidad:
		 * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
		 * 
		 * Las operaciones de Agregado implican convertir la coleccion en un flujo
		 * (Stream) de elementos que comienzan a circular por una tuberia (pipeline),
		 * que podemos entenderla como una linea de produccion, por ejemplo, una cadena
		 * donde se rellenan latas de conserva que en cada punto de la cadena se hace
		 * una operacion diferente sobre la lata de conserva, es decir, un operador la
		 * rellena, otro le pone la etiqueta, otro la cierra, otro la mete en una caja,
		 * etc.
		 * 
		 * Concretamente, la tuberia es una secuencia de operaciones de agregado, es
		 * decir, operaciones que agrupan los elementos que van circulando por la
		 * tubería para hacer algun tipo de Operacion.
		 * 
		 * Especificamente, la tuberia son los metodos de la clase Stream que tiene un
		 * origen que puede ser una coleccion, un array, un socket de red, etc. tambien
		 * tienen cero, una o varias operaciones intermedia y solamente una operacion
		 * terminal, al final de la tuberia, que reducira todos los elementos que van
		 * pasando por la tuberia a un solo elemento, o a una nueva coleccion
		 * 
		 * Las Operaciones de Agregado no es una sintaxis bonita, sino el soporte de la
		 * JVM que tienen detras estas operaciones es muy superior a todo lo que
		 * ateriormente existia con los bucles explicitos (entiendase for clasico y
		 * mejorado, while, do while, etc)
		 */

		Persona persona1 = new Persona("Luis", "Lopez", "Carmona", Genero.HOMBRE, LocalDate.of(1987, 12, 4),
				new BigDecimal(1250.50));
		Persona persona2 = new Persona("Luis", "Sanchez", "Brutez", Genero.HOMBRE, LocalDate.of(1989, 6, 13),
				new BigDecimal(950.50));
		Persona persona3 = new Persona("Maria", "Hidalgo", "Villa", Genero.MUJER, LocalDate.of(1990, 11, 18),
				new BigDecimal(1000.0));
		Persona persona4 = new Persona("Maria", "Candil", "Lamparo", Genero.MUJER, LocalDate.of(1986, 10, 23),
				new BigDecimal(1080.90));
		Persona persona5 = new Persona("Victoria", "Fermin", "Alcacer", Genero.MUJER, LocalDate.of(1985, 9, 12),
				new BigDecimal(1100.00));

		List<Persona> listadoPersonas = List.of(persona1, persona2, persona3, persona4, persona5);
		System.out.println("La lista del personal es: " + listadoPersonas);

		List<Persona> personasMutables = new ArrayList<Persona>();
		
		personasMutables.addAll(listadoPersonas);

		/* Se puede ordenar una coleccion a medida que se recorre, y no dejarla 
		 * permanentemente ordenada como sucede con el metodo sort() de la clase Colecctions */
		
		//Ejemplo #1. Ordenar la coleccion de personas mientras se recorre, segun el orden
		//natural
		System.out.println("Ejemplo #1");
		personasMutables.stream()
			.sorted()
			.forEach(System.out::println);
		
		//Ejemplo #2. Ordenar la coleccion de personas mientras se recorre por el salario
		// de la persona
		System.out.println("Ejemplo #2");
		personasMutables.stream()
			.sorted(Comparator.comparing(Persona::salario))
			.forEach(System.out::println);
		
		/* Ejercicio #1 del martes 30 de Junio 
		 * 
		 * Ordenar el listado de personas, por salario de mayor a menor */
		
		System.out.println("Ejercicio #1");
		personasMutables.stream()
			.sorted(Comparator.comparing(Persona::salario).reversed())
			.forEach(System.out::println);
			
		/* Ejercicio #2 del marts 30 de Junio
		 * 
		 * Ordenar por genero primero y luego por salario, a medida que se recorre
		 * la coleccion de persona para mostrarla */
		
		System.out.println("Ejercicio #2");
		personasMutables.stream()
			.sorted(Comparator.comparing(Persona::genero)
					.thenComparing(Persona::salario))
			.forEach(System.out::println);
		
		/* Ejercicio #3 del martes 30 de Junio 
		 * 
		 * Mostrar la persona que tiene el mayor salario de todas las personas */
		
		/* solucion Carlos: System.out.println("Ejercicio #3");
		personasMutables.stream()
			.max(Comparator.comparing(Persona::salario))
			.ifPresent(System.out::println);*/
		System.out.println("Ejercicio #3 segun el profesor: ");
		Optional<Persona> personaOptional = personasMutables.stream()
			.max(Comparator.comparing(Persona::salario));
		
		if (personaOptional.isPresent())
			System.out.println(personaOptional.get());
		
		/* Ejercicio #4 del martes 30 de Junio
		 * 
		 * Recuperar a la persona del genero Mujer, que tenga el menor 
		 * salario*/
		
		System.out.println("Ejercicio #4: La mujer con menor salario es: ");
		Optional<Persona> personaOptional2 = personasMutables.stream()
				.filter(p -> p.genero().equals(Genero.MUJER))
				.min(Comparator.comparing(Persona::salario));
		
		if (personaOptional.isPresent())
			System.out.println(personaOptional2.get());
		
	}

}