package menu;

import servicios.JuegoServicio;

import java.util.List;
import java.util.logging.Logger;

/**
 * Clase MenuListarJuegos
 * Se encarga de listar todos los juegos registrados en el sistema.
 * @version 1.1
 * @author kikev
 * Fecha: 20/11/2014
 */

public class MenuListarJuegos {
	 
	private static JuegoServicio juegoServicio;
	private static Logger logger = Logger.getLogger(MenuListarJuegos.class.getName());
			
	public MenuListarJuegos() {
		this.juegoServicio = new JuegoServicio();
	}

	 /**
     * Método para listar todos los juegos registrados.
     * @return true si el listado se realizó correctamente, false en caso de error.
     */
	public static boolean listarJuegos() {
        logger.info("Iniciando listado de todos los juegos registrados.");
		System.out.println("Cargando todos los juegos..");
		
		// Delegar a la capa de servicio
        boolean resultado = juegoServicio.listarJuegos();
        
        if (!resultado) {
        	System.out.println("No se ha podido cargar la lista de juegos. ");
        } else {
        	System.out.println("Carga correcta de la lista de juegos. ");
        }
        return resultado;
	}
	
	// Método main para probar
    public static void main(String[] args) {
    	
    	MenuListarJuegos menu = new MenuListarJuegos();       
        menu.listarJuegos();                            
   }
    
}
