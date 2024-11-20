package menu;

import servicios.JuegoServicio;
import utilidades.LeerTeclado;

/**
 * Clase MenuListarJuegos
 * Se encarga de listar todos los juegos registrados en el sistema
 * @version 1.1
 * @author kikev
 * Fecha: 20/11/2014
 */

public class MenuListarJuegos {
	
	private JuegoServicio juegoServicio;
			
	public MenuListarJuegos() {
		this.juegoServicio = new JuegoServicio();
	}

	public boolean listarJuegos() {
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
