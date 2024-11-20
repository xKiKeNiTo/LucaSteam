package servicios;

import datos.JuegoDato;
import modelos.Juego;
import utilidades.LectorCSV;

/**
 * Clase JuegoServicio
 * Descripción... 
 * 19/11/2024
 * Versión 1
 * Raúl
 */

public class JuegoServicio {
	
	/**
	 * Metodo que redirecciona la accion al paquete de datos
	 * @param j es el objeto Juego que recibimos y enviamos
	 * @return true si se completa, false si no
	 */
	public boolean darDeAlta(Juego j) {
		
		if (JuegoDato.darDeAlta(j)) return true;
		
		return false;
	}

}
