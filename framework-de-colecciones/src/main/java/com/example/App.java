package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
	
    public static void main(String[] args) {
    
    	/* Existen 3 formas de iterar o recorrer una coleccion, siendo una de ellas
	   	 * la unica que permite eliminar un elemento de la coleccion mientras se 
	   	 * recorre 
    	 * 
    	 * Traversing Collections:
    	 * https://docs.oracle.com/javase/tutorial/collections/interfaces
    	 * /collection.html
    	 * 
    	 * Formas de recorrer una coleccion
    	 * 
    	 * 1- Mediante un Iterador (Iterator en Ingles)
    	 * 2- Mediante una sentencia for mejorada
    	 * 3- Mediante Operaciones de Agregado (Metodos de la clase Stream, 
    	 * Expresiones Lambda,
    	 * 	  Metodos por referencia, en fin, PROGRAMACION FUNCIONAL)
    	 * 
    	 * Y la ultima, que no por se la ultima es la menos importante, sino todo 
    	 * lo contrario, es la sugerida, y por ello la dejamos para el final
    	 * */
		
		// Uso de la interfaz Iterator para eliminar un elemento de la coleccion 
    	//mientras se recorre.Para ello, como Ejercicio # 1 del viernes 19 de Junio,
    	//se pide:
    	
		/* Crear una lista de Persona, mutable, donde cada Persona sea un record, 
		 * con las siguientes propieades
		* 
		* - nombre
		* - apellido1
		* - apellido2
		* - genero
		* - fechaNacimiento
		* - salario
		* 
		* La lista de Persona tiene que contener 5 personas
		* 
		* -- Para hacer con el Profesor
		* Una vez creada la lista, la recorremos y eliminamos a todas las personas 
		* del genero HOMBRE, que tengan salario inferior a la media */
    	
    	Persona persona1 = new Persona("Carlos", "Lopez", "Carmona", 
    			Genero.HOMBRE, LocalDate.of(1987, 12, 4), new BigDecimal(1250.50).setScale(2, RoundingMode.HALF_UP));
    	Persona persona2 = new Persona("Jose", "Sanchez", "Brutez", 
    			Genero.HOMBRE, LocalDate.of(1989, 6, 13), new BigDecimal(950.50).setScale(2, RoundingMode.HALF_UP));
    	Persona persona3 = new Persona("Laura", "Hidalgo", "Villa", 
    			Genero.MUJER, LocalDate.of(1990, 11, 18), new BigDecimal(1000.0).setScale(2, RoundingMode.HALF_UP));
    	Persona persona4 = new Persona("Julia", "Candil", "Lamparo", 
    			Genero.MUJER, LocalDate.of(1986, 10, 23), new BigDecimal(1080.90).setScale(2, RoundingMode.HALF_UP));
    	Persona persona5 = new Persona("Victoria", "Fermin", "Alcacer", 
    			Genero.MUJER, LocalDate.of(1985, 9, 12), new BigDecimal(1100.00).setScale(2, RoundingMode.HALF_UP));
    	
    	List<Persona> listadoPersonas = List.of(persona1, persona2, persona3, persona4, persona5);
    	System.out.println("La lista del personal es: " + listadoPersonas);
    	
    	List<Persona> listadoPersonasMutable = new ArrayList<Persona>();
    	
    	listadoPersonasMutable.addAll(listadoPersonas);
    	
    	Persona persona6 = new Persona("Javier", "Carrasco", "Ganero", Genero.HOMBRE, LocalDate.of(1992, 4, 27), 
    				new BigDecimal(990.75).setScale(2, RoundingMode.HALF_UP));
    	
    	listadoPersonasMutable.add(persona6); 
    	
    	System.out.println("El listado con el fichaje nuevo es: " + listadoPersonasMutable);
    	
    	
    	
    }
} 	