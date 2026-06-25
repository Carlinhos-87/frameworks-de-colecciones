package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

		/*
		 * Obtener, utilizando Operaciones de Agregado, el salario promedio de todas las
		 * personas del genero MUJER
		 */

		/*
		 * Paso numero uno, convertir la coleccion de personas, en este caso, en un
		 * flujo (Stream) de elementos Persona, que va comenzar a circular por una
		 * tuberia (pipeline), es decir, una secuencia de operaciones, metodos de la
		 * clase Stream
		 */

		/*
		 * La colecciones se puede convertir en un flujo, utilizando el metodo stream()
		 * o parallelStream(), este ultimo permitiria procesar los elementos de la
		 * coleccion en un flujo paralelo, haciendo uso de todos los nucleos y los hilos
		 * de ejecucion del procesador del equipo. No obstante, si la lista no es de
		 * muchos elementos no se va a notar gran diferencia entre utilizar el metodo
		 * stream() o el metodo parallelStream()
		 */

		/*
		 * Las operaciones de agregado conjuntamente con las expresiones Lambda, los
		 * metodos de la clase Stream, y los metodos por referencia es lo que se le
		 * llama tambien, la PROGRAMACION FUNCIONAL, que aunque JAVA no es un lenguaje
		 * Funcional Puro, la implementa conjuntamente con la programacion orientada a
		 * objetos.
		 * 
		 * En la PROGRAMACION FUNCIONAL, las funciones, los metodos, se convierten en
		 * ciudadanos de primera clase, es decir, que al igual que con las variables, se
		 * pueden pasar, las funciones como parametros a los metodos y se pueden
		 * devolver tambien. La PROGRAMACION FUNCIONAL, entre otras cosas, permite pasar
		 * funcionalidad a los metodos, es un tipo de programacion declarativa, no
		 * imperativa, se pide que es lo que se desea y el metodo responde a esa
		 * peticion (request) de una forma concreta
		 */

		Stream<Persona> flujoDePersonas = personasMutables.stream();

		/* El metodo filter recibe lo que esta entre parentesis */

		Predicate<? super Persona> predicate;

		/*
		 * Cuando en el diamante esta la palabra reservada super, a dicha coleccion se
		 * le pueden agregar elementos, pero cuando la palabra reservada es extends a
		 * dicha coleccion NO se le pueden agregar elementos, porque es una coleccion
		 * inmutable Ejemplo a continuacion:
		 */
		List<? extends Persona> listaInmutable; // No se puede usar el metodo add() para
												// agregar elementos
		List<? super Persona> listaModificable; // Si se le pueden agregar elementos con
												// el metodo add()

		/*
		 * Predicate es una interfaz funcional. ¿Que es una Interfaz Funcional? Es una
		 * interface que tiene varios metodos (metodos con cuerpo, implementados, no
		 * abstractos que pueden ser static, private, etc.), pero solamente UN METODO
		 * ABSTRACTO
		 * 
		 * Concretamente la interfaz funcional Predicate tiene solamente un metodo
		 * Abstracto, de todos los que tiene, dicho metodo se llama test(T t) y prueba
		 * que el objeto que recibe como parametro cumpla una condicion determinada, y
		 * si la cumple, el objeto pasara el siguiente nivel de la tuberia
		 * 
		 * A Continuacion explico lo que esta dentro del diamante <? super Persona>
		 * 
		 * Una lista que en el diamente tenga ? significa que es una coleccion que
		 * admite cualquier tipo de elemento. El caracter ? se le llama comodin
		 * 
		 * List<?> listaDeCualquierCosa; Pero este lista es dificil de manejar
		 * posteriormente, por lo que una coleccion que utilice el signo ? debe estar
		 * acotada, por ejemplo Collection<? super Persona> // Partimos de que tener una
		 * coleccion totalmente generica no es una buena idea, sino que dicha coleccion
		 * tiene que estar acotada, como seria este caso que indica que esta coleccion
		 * puede almacenar elementos de cualquier tipo (?) pero que este acotado por
		 * encima (super) por el tipo Persona, ES DECIR, que en este caso la coleccion
		 * admite elementos de cualquier tipo donde la clase Persona sea el super tipo,
		 * es decir, la clase base, la madre, y por supuest tipos Persona tambien va a
		 * admitir
		 */

		/*
		 * El metodo filter esta gritando que le pasen como parametro "algo" que
		 * implemente la interfaz Predicate, y de momento lo unico que implementa una
		 * interfaz es una clase
		 * 
		 * Y vamos a comenzar implementando una clase externa llamada Filtro
		 */

		/*
		 * IMPORTANTE!!! Crear una clase externa para satisfacer la condicion del metodo
		 * filter, es una exageracion, porque el objetivo de dicha clase es utilizarla
		 * en el metodo filter nada mas.
		 * 
		 * Entoces ¿Que se sugiere hacer? Se necesita un tipo de clase que se utilice en
		 * el mismo lugar donde se necesita, no fuera de ahí, es decir, se necesita una
		 * denominada CLASE ANONIMA, que es un tipo de clase que permite instanciar un
		 * objetos en el mismo lugar que se implementa la clase
		 * 
		 * La clase anonima es como una expresion de clase, que se utiliza para
		 * implementar una interfaz, aunque tambien se puede utilizar para implementar
		 * una clase abstracta.
		 * 
		 * Antes de utilizar una clase anonima para implementar la interfaz Predicate
		 * vamos a crear una clase anonima para implemtar una sencilla interfaz llamada
		 * saludo
		 * 
		 * Una clase anonima es una expresion de clase, por lo cual tiene que terminar
		 * en punto y coma
		 */

		Saludar saludar = new Saludar() {

			@Override
			public void misSaludosParaTi(String nombre) {
				// TODO Auto-generated method stub
				System.out.println("Hola " + nombre);

			}
		};

		saludar.misSaludosParaTi("Maria");

		Predicate<Persona> predicate2 = new Predicate<Persona>() {

			@Override
			public boolean test(Persona persona) {
				// TODO Auto-generated method stub
				return persona.genero().equals(Genero.MUJER);
			}
		};

		/*
		 * Ejercicio n# 1 del martes 23 de Junio.
		 * 
		 * Utilizando una clase anonima implementar la interfaz Predicate que necesita
		 * el metodo filter, es decir, pasar el criterio de filtro al metodo filter
		 * mediante una expresion de clase anonima
		 */

		// flujoDePersonas.filter(new CriterioDeFiltro());

//		//Variante de solucion preferida
//		flujoDePersonas.filter(new Predicate<Persona>() {
//
//			@Override
//			public boolean test(Persona persona) {
//				// TODO Auto-generated method stub
//				return persona.genero().equals(Genero.MUJER);
//			}
//		});

		/*
		 * Si la interface que se va a implementar con una clase anonima es una
		 * interface funcional utilizar una clase anonima es todavia EXCESIVO, demasiado
		 * codigo por lo cual, ¿que se utiliza entonces? Se utiliza una EXPRESION LAMBDA
		 * ¿que es una expresion LAMBDA? Es como un metodo anonimo, se utiliza para
		 * pasar a un metodo la implementacion del unico metodo abstracto que hay que
		 * implementar.
		 * 
		 * A continuacion la sintaxis de una expresion LAMBDA
		 */

		OptionalDouble optionalDelSalarioPromedio = flujoDePersonas
				.filter(p -> p.genero().equals(Genero.MUJER))
				.mapToDouble(persona -> persona.salario().doubleValue())
				.average();

		/*
		 * ¿Que es un Optional? El tipo de dato Optional es una de las maravillas de las
		 * versiones mas recientes de JAVA, surge en la version 8 de JAVA y el tipo
		 * optional te protege del temido NullPointerException, es decir, que tu
		 * intentes trabajar con un objeto y este tome el valor NULL y el problema es
		 * que cuando en una operacion interviene un NULL todo se vuelve NULL
		 * 
		 * Finalmente, el tipo Optional hay que verlo como una cajita de sorpresa, donde
		 * puede venir el resultado esperado, que seria el salario promedio en este
		 * caso, o seria un valor NULL porque el promedio no se pudo calcular, porque
		 * ninguna de las personas del genero MUJER tenian salario
		 */

		if (optionalDelSalarioPromedio.isPresent()) {

			/*
			 * De la cajita del Optioinal puedo extraer el salario promedio sin ningun
			 * peligro
			 */

			double salarioPromedio = optionalDelSalarioPromedio.getAsDouble();
			System.out.println("El salario promedio es: " + salarioPromedio);
		}

		/*
		 * Ejemplo # 1 del Miercoles 24 de Junio
		 * 
		 * Utilizando Operaciones de Agregado, recorrer la lista de personas y obtener
		 * una nueva coleccion que contenga solamente los nombres de las personas, pero
		 * sin duplicados
		 */

		Set<String> nombresSinDuplicados = personasMutables.stream()
				.map(p -> p.nombre()).collect(Collectors.toSet());

		/*
		 * Si al final de la tuberia se quiere obtener una nueva coleccion, la operacion
		 * terminal tiene que ser el metodo collect(), que recibe la implementacion de
		 * la interfaz Collector a traves de una clase que tiene el mismo nombre pero en
		 * plural, Collectors en este caso, que tendra a su vez metodos estaticos, en la
		 * propia clase Collectors para trabajar con los elementos que se colectan al
		 * final de la tuberia
		 */

		/*
		 * Cuando la expresion LAMBDA lo unico que hace es llamar al metodo que es quien
		 * realmente hace el trabajo, utilizar una expresion LAMBDA es poco eficiente y
		 * redundante por lo cual lo mejor es que el propio metodo haga el trabajo, sin
		 * ningun intermediario, es decir que lo correcto es pasar el metodo por
		 * referencia
		 */

		Set<String> nombresSinDuplicados2 = personasMutables.stream()
				.map(Persona::nombre).collect(Collectors.toSet());

		// A continuacion vamos a imprimir los elementos de la coleccion
		// nombresSinDuplicados2

		System.out.println("Set de nombres sin duplicado: ");
		// excesivo: nombresSinDuplicados2.stream().forEach(nombre ->
		// System.out.println(nombre));

		/*
		 * En la sentencia anterior, la expresion LAMBDA lo unico que hace es llamar al
		 * metodo println, por tanto se puede quitar la LAMBDA y pasar el metodo por
		 * referencia
		 * 
		 * En las ultimas versiones de JAVA, no hace falta el metodo stream() si
		 * directamente se utiliza una operacion terminal a continuacion del origen de
		 * la tuberia
		 */

		nombresSinDuplicados2.forEach(System.out::println);
		
		/* OBJECT ORDERING (Ordenamiento de Objetos)
		 * 
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
		 * 
		 * Los algoritmos son una parte integral del framework de colecciones
		 * 
		 * A continuacion vamos a ver los algoritmos de ordenamiento (sort) implementados
		 * en la interface Collections
		 * 
		 * Como ejemplo vamos a ordenar la lista de nombres siguiente segun el Orden Natural
		 * lexicograficamente de la A a la Z */
		
		List<String> nombres = Arrays.asList("Miguel", "Angel", "Youssef", "Yodalis", "Elida", 
				"Jakelin", "Juan", "Carlos", "Gina");
		
		System.out.println("Listado original de nombres: ");
		nombres.forEach(System.out::println);
		
		//Ordenamiento segun el orden natural (Natural Ordering)
		Collections.sort(nombres);
		
		System.out.println("Listado de nombres ordenado, alfabeticamente, lexicograficamente");
		nombres.forEach(System.out::println);
		
		/* Vamos a intentar ordenar la lista de personas, 
		 * ¿Que va a pasar?
		 * 
		 * Que no es posible ordenar mi listado de personas, compuesto por elementos que son
		 * record de Persona, ¿Por que entonces si pudo ordenar las lista de nombres? Respuesta:
		 * Porque todos los tipos de datos de JAVA implementan la interfaz Comparable, miesntras
		 * que el tipo record Persona creado por nosotros no implementa la interfaz Comparable,
		 * en resumen, que si no se implementa la interfaz Comparable el metodo sort() no tiene
		 * medios para comparar los elementos del tipo de datos concreto.
		 * 
		 * IMPORTANTE!!! El orden natural viene dado por la implementacion de la interfaz Comparable,
		 * y si el tipo de datos no implementa dicha interfaz pues NO tiene orden natural, que se
		 * podrá  ordenar de otra manera pero no segun orden natural  
		 * 
		 * ver la tabla que esta en el link suministrado inicialmente: */
		
		/* Se entiende que para ordenar la lista de personas, el tipo de datos de los elementos que
		 * conforman la lista de personas, que es el record Persona, tiene que implementar, si o si
		 * la interfaz Comparable, para que una coleccion de tipo record de Persona puesda ser 
		 * ordenada segun el orden natural*/
		
		System.out.println("Listado de personas sin ordenar: ");
		personasMutables.forEach(System.out::println);
		
		Collections.sort(personasMutables);
		
		System.out.println("Listado de personas ordenado segun el orden natural: ");
		personasMutables.forEach(System.out::println);
		
		/* Imaginate que el jefe de nuestro departamento no necesita ordenar las personas segun
		 * el Orden Natural del record Persona, sino que el necesita ordenar la lista de personas
		 * por el salario, de mayor a menor, es decir, en orden inverso
		 * 
		 * El problema es que en nuestro departamento no tenemos el codigo fuente del 
		 * record Persona para cambiar el orden natural ¿Que podemos hacer entonces para ordenar
		 * las personas por el salario sin modificar el Orden Natural?*/
		
		/* Respuesta, por suerte, el metodo sort() de la clase Collections puede recibir un
		 * segundo parametro que seria el criterio de comparacion, para comparar dos personas
		 * sin que intervenga el Orden Natural*/
		
		Collections.sort(personasMutables, (p1, p2) -> 
			p1.salario().compareTo(p2.salario()));
		
		System.out.println("Listado de personas ordenado segun el comparator por el salario "
				+ "de menor a mayor");
		personasMutables.forEach(System.out::println);
		
		/* ¿Como hacer para que muestre las personas de mayor salario primero?
		 * Respuesta. En el cuerpo de la lambda cambiando el orden, primero persona2 y luego
		 * persona1*/
		
		Collections.sort(personasMutables, (p2, p1) -> 
		p2.salario().compareTo(p1.salario()));
	
	System.out.println("Listado de personas ordenado segun el comparator por el salario "
			+ "de mayor a menor");
	personasMutables.forEach(System.out::println);
		
		
		
	}
}