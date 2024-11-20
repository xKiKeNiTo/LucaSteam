package datos;


import java.util.ArrayList;
import java.util.List;

import modelos.Juego;
import utilidades.CSV;

import java.io.IOException;
import java.util.List;

import modelos.Juego;
import modelos.Platform;
import modelos.Genre;
import utilidades.LectorCSV;


/**
 * Clase JuegoDato
 * Para interactuar con los datos de los juegos. Recibimos los datos desde el CSV. 
 * 19/11/2024
 * @version 1
 * @author raul_
 * Fecha: 20/11/2024
 */

public class JuegoDato {
	

	public static boolean listarJuegos() {
		
	}
	
	/**
	 * Metodo que recibiendo un unico objeto Juego, hace uso de la utilidad "guardarCSV" y actualiza el CSV
	 * @param j es el Juego que queremos guardar en el CSV
	 * @return true si se ha conseguido hacer con exito, false si no
	 */
	public static boolean darDeAlta(Juego j) {

	public static boolean listarJuegos() {
		LectorCSV lector = new LectorCSV();
		
		try {
			lector.leerCSV();
			List<Juego> juegos = lector.getJuegos();
			
			if (juegos.isEmpty()) {				
				System.out.println("No hay datos disponibles en el CSV");
				return false;				
			}
			
			// Mostrar los juegos por consola
			System.out.println("Juegos: ");
			for (Juego juego : juegos) {
				System.out.println(juego);
			}
			return true;
			
		} catch (IOException e) {
			System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            return false;
		}

		
		List<Juego> juegos = new ArrayList<>();
		
		juegos.add(j);
		
		if(CSV.guardarCSV(juegos, CSV.fichero)) return true;
		
		return false;
	}
	
}
