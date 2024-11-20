package datos;

import java.io.IOException;
import java.util.List;

import modelos.Juego;
import modelos.Platform;
import modelos.Genre;
import utilidades.LectorCSV;

/**
 * Clase JuegoDato
 * Clase JuegoDato para interactuar con los datos de los juegos. Recibimos los datos desde el CSV. 
 * 19/11/2024
 * @version 1
 * @author raul_
 */

public class JuegoDato {
	
	public boolean listarJuegos() {
		LectorCSV lector = new LectorCSV();
		
		try {
			lector.leerCSV();
			List<Juego> juegos = lector.getJuegos();
			
			if (juegos.isEmpty()) {				
				System.out.println("No hay datos disponibles en el CSV");
				return false;				
			}
			
			// Mostrar los juegos por consola
			System.out.println("Juegos desde datos: ");
			for (Juego juego : juegos) {
				System.out.println(juego);
			}
			return true;
			
		} catch (IOException e) {
			System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            return false;
		}
		
	}
	
}
