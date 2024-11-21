package datos;

import java.util.ArrayList;
import java.util.List;

import modelos.Juego;
import utilidades.CSV;

import java.io.IOException;
import modelos.Genre;

/**
 * Clase JuegoDato Para interactuar con los datos de los juegos. Recibimos los
 * datos desde el CSV. 19/11/2024
 * 
 * @version 1
 * @author raul_ Fecha: 20/11/2024
 */

public class JuegoDato {
	
	private static CSV csv = new CSV();
	
	/**
	 * Metodo que recibiendo un unico objeto Juego, hace uso de la utilidad
	 * "guardarCSV" y actualiza el CSV
	 * 
	 * @param j es el Juego que queremos guardar en el CSV
	 * @return true si se ha conseguido hacer con exito, false si no
	 */
	public static boolean darDeAlta(Juego j) {
		List<Juego> juegos = new ArrayList<>();

		juegos.add(j);

		if (CSV.guardarCSV(juegos, CSV.fichero))
			return true;

		return false;

	}

	public static boolean listarJuegos() {
		
		
		
		try {
			csv.leerCSV();
			List<Juego> juegos = csv.getJuegos();
			
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
	}

	/**
	 * Filtra los juegos cargados en la clase por un género específico.
	 *
	 * @param genero El género por el cual filtrar.
	 * @return Una lista de juegos que corresponden al género proporcionado.
	 */
	public static List<Juego> listarPorGenero(Genre genero) {

		List<Juego> juegosFiltrados = new ArrayList<>();
		try {
			csv.leerCSV();
			List<Juego> juegos = csv.getJuegos();
			for (Juego juego : juegos) {
				if (juego.getGenre() == genero) {
					juegosFiltrados.add(juego);
				}
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo CSV: " + e.getMessage());
		}
		return juegosFiltrados;
	}

	public static void main(String[] args) {
		listarPorGenero(Genre.Misc);
	}
}
