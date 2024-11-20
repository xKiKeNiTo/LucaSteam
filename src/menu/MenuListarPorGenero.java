package menu;

import modelos.Juego.Genre;
import servicios.JuegoServicio;
import utilidades.LeerTeclado;
import java.util.List;

/**
 * 
 * @version 1.0
 */
public class MenuListarPorGenero {
	
	public static void listarPorGenero() {
		
		System.out.println("Listado de juegos por género:");

        // Mostrar opciones de géneros
        Genre[] generos = Genre.values();
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i + 1) + ". " + generos[i]);
        }
        
        // Pedir selección
        int opcion = LeerTeclado.leerInt("Seleccione un género (1-" + generos.length + "):");
        while (opcion < 1 || opcion > generos.length) {
            System.out.println("Opción inválida. Intente nuevamente.");
            opcion = LeerTeclado.leerInt("Seleccione un género (1-" + generos.length + "):");
        }
        
        // Obtener el género seleccionado
        Genre generoSeleccionado = generos[opcion - 1];
	
        // Llamar al servicio para obtener la lista de juegos por género
        JuegoServicio juegoServicio = new JuegoServicio();
        List<String> juegos = juegoServicio.listarPorGenero(generoSeleccionado);
        
        // Mostrar resultados
        if (juegos.isEmpty()) {
            System.out.println("No hay juegos registrados en el género " + generoSeleccionado + ".");
        } else {
            System.out.println("Juegos del género " + generoSeleccionado + ":");
            juegos.forEach(System.out::println);
        }
	}

}
