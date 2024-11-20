package datos;

import java.util.ArrayList;
import java.util.List;

import modelos.Juego;
import utilidades.CSV;

/**
 * Clase JuegoDato
 * Descripción... 
 * 19/11/2024
 * Versión 1
 * Raúl
 */

public class JuegoDato {
	
//	public static boolean listarJuegos() {
//		
//	}
	
	/**
	 * Metodo que recibiendo un unico objeto Juego, hace uso de la utilidad "guardarCSV" y actualiza el CSV
	 * @param j es el Juego que queremos guardar en el CSV
	 * @return true si se ha conseguido hacer con exito, false si no
	 */
	public static boolean darDeAlta(Juego j) {
		
		List<Juego> juegos = new ArrayList<>();
		
		juegos.add(j);
		
		if(CSV.guardarCSV(juegos, CSV.fichero)) return true;
		
		return false;
	}

}
