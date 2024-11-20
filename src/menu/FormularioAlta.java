package menu;

import modelos.Juego;
import modelos.Juego.Platform;
import servicios.JuegoServicio;
import modelos.Juego.Genre;
import utilidades.LeerTeclado;

/**
 * Clase para gestionar el formulario de alta de juegos.
 * 19/11/2024
 * @version 1.0
 * @author kikev
 */
public class FormularioAlta {
	
	public static boolean mostrarMenu() {
		try {

            System.out.println("Formulario para dar de alta un nuevo juego:");

            int rank = LeerTeclado.leerInt("Ingrese el ranking del juego:");
            String name = LeerTeclado.leerLinea("Ingrese el nombre del juego:");
            int year = LeerTeclado.leerInt("Ingrese el año de lanzamiento:");
            String publisher = LeerTeclado.leerLinea("Ingrese el editor del juego:");
            double naSales = LeerTeclado.leerDouble("Ingrese las ventas en Norteamérica (en millones):");
            double euSales = LeerTeclado.leerDouble("Ingrese las ventas en Europa (en millones):");
            double jpSales = LeerTeclado.leerDouble("Ingrese las ventas en Japón (en millones):");
            double otherSales = LeerTeclado.leerDouble("Ingrese las ventas en otras regiones (en millones):");
            double globalSales = naSales + euSales + jpSales + otherSales;

            Platform platform = seleccionarPlataforma();
            Genre genre = seleccionarGenero();
			
            Juego juego = new Juego(rank, name, year, publisher, naSales, euSales, jpSales, otherSales, globalSales, platform, genre);
            JuegoServicio juegoServicio = new JuegoServicio();
            juegoServicio.darDeAlta(juego);
            
			return true;
		} catch (Exception e) {
			System.err.println("Error al dar de alta el juego: " + e.getMessage());
            return false;
		}
				
	}
	
	private static Platform seleccionarPlataforma() {
        System.out.println("Seleccione la plataforma del juego:");
        Platform[] plataformas = Platform.values(); //Muestra todas las posibles plataformas a seleccionar
        for (int i = 0; i < plataformas.length; i++) {
            System.out.println((i + 1) + ". " + plataformas[i]);
        }
        System.out.println((plataformas.length + 1) + ". Salir");

        //Pide un input para seleccionar la plataforma
        int opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + plataformas.length + "):");
        while (opcion < 1 || opcion > plataformas.length) {
            System.out.println("Opción inválida. Intente de nuevo.");
            opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + plataformas.length + "):");
        }
        
        if (opcion == plataformas.length + 1) {
            System.out.println("Saliendo de la selección de plataforma.");
            return null; // Indicate the user opted to exit
        }
        
        //Devuelve la plataforma seleciconada
        return plataformas[opcion - 1];
    }
	
	private static Genre seleccionarGenero() {
	    System.out.println("Seleccione el género del juego:");
	    Genre[] generos = Genre.values();//Muestra todas los posibles géneros a seleccionar
	    for (int i = 0; i < generos.length; i++) {
	        System.out.println((i + 1) + ". " + generos[i]);
	    }
	    System.out.println((generos.length + 1) + ". Salir");

	    //Pide un input para seleccionar el género
	    int opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + (generos.length + 1) + "):");
	    while (opcion < 1 || opcion > generos.length + 1) {
	        System.out.println("Opción inválida. Intente de nuevo.");
	        opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + (generos.length + 1) + "):");
	    }

	    if (opcion == generos.length + 1) {
	        System.out.println("Saliendo de la selección de género.");
	        return null;
	    }
	    
	    //Devuelve el género seleciconado
	    return generos[opcion - 1];
	}
	
}
