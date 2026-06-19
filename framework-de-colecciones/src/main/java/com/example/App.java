package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class App {
	
	/* Las variables, que son atributos o campos de una clase se les asigna 
	 * automaticamente un valor por defecto, lo cual no ocurre con una variable
	 * que está declarada en un bloque, es decir, entre llaves de apertura
	 * y cierre ( {} ), que por lo general dicho bloque viene siendo un metodo,
	 * como el metodo main, por ejemplo
	 * 
	 * Por lo tanto, la variable que aparece a continuacion NO necesita que se 
	 * le asigne ningun valor por defecto*/
	//int xx = 0;
	int x;
	
    public static void main(String[] args) {
    
    /* Collections framework:
     * https://docs.oracle.com/javase/tutorial/collections/index.html
     * 
     * Conceptos básicos y definiciones:
     * 
     * ¿Que es una coleccion? Es un almacen/contenedor donde se almacenan
     * elementos del mismo tipo o tipos relacionados, para su posterior 
     * tratamiento. 
     * 
     * Las colecciones, en primer lugar, son interfaces, no son clases, que
     * se implementan cada una con mas de una clase concreta.
     * 
     *  El framework de colecciones permite tratat a todas las colecciones
     *  de la misma forma, es decir, con los mismos metodos
     *  
     *  En Java los arrays se convierten a colecciones para su tratamiento 
     *  más eficiente.
     *  
     *  En resumen, las colecciones se enfocan en almacenar de forma eficiente 
     *  la informacion para su posterior tratamiento
     *  
     *  En la biblioteca de Java, es decir, donde estan organizados en paquetes
     *  las clases y las interfaces, todos los elementos, incluyendo las colecciones,
     *  son Genericos
     *  
     *  ¿Que es la Genericidad? Es que una coleccion pueda trabajar con tipos de 
     *  datos diferentes, pero una vez que se especifica el tipo de datos ya no se
     *  puede cambiar y si se produce un error este seria detectado en tiempo de 
     *  compilacion que es mas facil de detectar que en tiempo de ejecucion
     *  
     *  Una de las colecciones mas utilizadas es la interface List, que permite 
     *  almacenar elementos duplicados.
     * <Integer>
     * Hay otras interfaces como Set que no permiten elementos duplicados
     * */
    
    	//List<String> nombres;	
    	
    	List<Integer> numeros = null;
    	
    	/* Diferentes formas de crear una coleccion, y saber si la coleccion 
    	 * resultante es de tamaño fijo, pero que se puede modificar, o es una
    	 * coleccion totalmente inmutable*/
    	
    	/* Coleccion creada a partir de un array*/
    	
    	//Primero declaramos el array de numeros enteros
    	
    	int[] arrayDeEnteros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	
    	/* En el momento de declarar una variable, ¿Ques es preferible, especificar
    	 * como tipo de datos, un tipo primitivo o un tipo objeto?
    	 * */
    	Integer dd;
    	int ddd;
    	
    	/* El tipo de dato objeto no existe, lo que existe es el tipo de dato
    	 * primitivo, por lo cual cuando se va a declarar una variable es
    	 * preferible usar como tipo de dato, un dato primitivo en lugar
    	 * de su contraparte objeto
    	 * 
    	 * No obstante, el tipo primitivo tiene algunas limitaciones, como no
    	 * podersele asignar un valor null, tampoco se puede utilizar en el 
    	 * diamante y no tiene propiedades ni metodos asociados*/
    	
    	//A partir del arrayDeEnteros, se puede crear una lista como se muestra
    	//a continuacion
    	
    	var numeros2 = Arrays.asList(arrayDeEnteros);
    	
    	/* La palabra VAR que acabamos de utilizar, NO es una caracteristica de
    	 * Java version 8 sino que es mucho mas reciente y se puede utilizar
    	 * localmente o tambien en los parametros o argumentos de un metodo
    	 * 
    	 * ¿Para que se utiliza VAR? Para no tener que especificar el tipo de
    	 * datos explicitamente, y que sea el compilador de Java quien infiera
    	 * el tipo de datos
    	 * 
    	 * Ejemplos a continuacion*/
    	
    	var nombre = "Youssef";
    	var numero = 24;
    	
    	/* Aunque es muy comodo utilizar la palabra reservada var no se recomienda 
    	* cuando uno esta comenzando en el mundo de la programacion, es decir, 
    	* cuando uno es un Junior.
    	* 
    	* Cuando uno es Junior debe especificar explicitamente el tipo de dato de la 
    	* variable */
    	
    	
    	/* A continuacion vamos a declarar un array de nombres y convertirlo a una
    	 * lista de nombres*/
    	
    	String[] arrayNombres = {"Jakeline", "Juan Carlos", "Elida", 
    			"Miguel", "Youssef", "Gina"};
    	
    	List<String> nombres = Arrays.asList(arrayNombres);
    	
    	
    	/* Una coleccion creada a partir de un array, genera una coleccion de
    	 * tamaño fijo, es decir, que no se le pueden agregar ni eliminar ningun
    	 * elemento de la coleccion, pero si se puede modificar*/
    	
    	/* Si intentamos agregar un nuevo nombre a la lista, es decir, a la 
    	 * coleccion nombres, ¿Que va a pasar?*/
    	
    	System.out.println("... Intentando agregar un nuevo nombre a la lista");
    	//nombres.add("Yodalis");
    	
    	//La sentencia anterior da error en tiempo de ejecucion, por lo cual la 
    	//hemos comentado
    	
    	/* Vamos a intentar modificar un elemento de la lista, y veremos que si
    	 * es posible, por ejemplo, vamos a sustituir Elida por Yodalis*/
    	
    	//Quiero ver el nombre que esta en la posicion 2 de la lista
    	System.out.println("El nombre en la posicion 2 de la lista es: " + nombres.get(2));
    	
    	nombres.set(2, "Yodalis");
    	
    	System.out.println("El nombre en la posicion 2 tras el cambio es: " + nombres.get(2));
    	
    	/* ¿Como crear una coleccion totalmente inmutable? 
    	* 
    	* Respuesta, utilizando metodos estaticos (static) que implementan el patron de
    	* diseño factoria.
    	* 
    	* El Patron de diseño factoria es un patron creacional, para crear objetos sin
    	* utilizar operador new, es decir, sin utilizar un constructor */
    	
    	List<String> nombresInmutables = List.of("Yodalis", "Gina", "Jakeline", "Elida");
    	
    	/* Ejercicio # 1 del Jueves 18 de Junio 
    	* 
    	* Crear una lista inmutable, donde cada elemento de lista sea un record 
    	* Manzana, que tenga las propiedades que usted estime necesarias o 
    	* convenientes, como podrian ser peso, variedad, sabor, precio, etc. 
    	* 
    	* La cantidad de elementos de la lista debe ser 3 */
    	
    	Manzana manzana1 = Manzana.builder()
    			.variedad("Golden")
    			.peso(500.0)
    			.precio(new BigDecimal(2.3).setScale(2, RoundingMode.HALF_UP))
    			.build();
    	Manzana manzana2 = Manzana.builder()
    			.variedad("Royal")
    			.peso(350.5)
    			.precio(new BigDecimal(1.8).setScale(2, RoundingMode.HALF_UP))
    			.build();
    	Manzana manzana3 = Manzana.builder()
    			.variedad("Reineta")
    			.peso(750.0)
    			.precio(new BigDecimal(4.7).setScale(2, RoundingMode.HALF_UP))
    			.build();
    	
    		
    	List<Manzana> listaManzanas = List.of(manzana1, manzana2, manzana3);
    	
    	System.out.println("El contenido de la lista de manzanas es: " + listaManzanas);
    	
    	/* Creacion de una coleccion que NO es de tamaño fijo, NI Inmutable, 
    	 * es decir, una coleccion que si se puede modificar, agregar 
    	 * y eliminar elementos */
    	
    	/* Para agregar elementos a una coleccion utilizando el metodo add(), 
    	 * por ejemplo, dicha coleccion tiene que tener espacio reservado para 
    	 * ella a traves de el constructor de alguna de las clases que implementa 
    	 * los metodos abstractos de dicha coleccion */
    	
    	List<Manzana> listaModificableDeManzanas = new ArrayList<Manzana>();
    	
    	listaModificableDeManzanas.addAll(listaManzanas);
    	
    	listaModificableDeManzanas.add(Manzana.builder()
    			.variedad("Red Golden")
    			.peso(660.4)
    			.precio(new BigDecimal(3.4).setScale(2, RoundingMode.HALF_UP))
    			.build());
    	
    	System.out.println("Coleccion Modificable");
    	System.out.println(listaModificableDeManzanas);
    }
} 	