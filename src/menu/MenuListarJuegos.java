package menu;

import servicios.JuegoServicio;

import java.util.List;

/**
 * Clase para listar todos los juegos.
 * @version 1.0
 */
public class MenuListarJuegos {
	private static final JuegoServicio servicio = new JuegoServicio();
    public static void listarJuegos() {
    	
        System.out.println("Listado de todos los juegos registrados:");
        // Llama al servicio para obtener todos los juegos
        List<String> juegos = servicio.listarJuegos();
      
        
        // Muestra los juegos o indica si no hay registros
        if (juegos.isEmpty()) {
            System.out.println("No hay juegos registrados.");
        } else {
            juegos.forEach(System.out::println);
        }
    }
}
