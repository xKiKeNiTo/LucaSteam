package datos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelos.Genre;
import modelos.Juego;
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
		
	// }
	
	/**
     * Filtra los juegos cargados en la clase por un género específico.
     *
     * @param genero El género por el cual filtrar.
     * @return Una lista de juegos que corresponden al género proporcionado.
     */
    public static List<Juego> listarPorGenero(Genre genero) {
		List<Juego> juegosFiltrados = new ArrayList<>();
		try {
			juegos = lector.getJuegos();
			for (Juego juego : juegos) {
				if (juego.getGenre() == genero) {
					juegosFiltrados.add(juego);
				}
			}
		} catch (Exception e) {
		}
        return juegosFiltrados;
    }

	public static void main(String[] args) {
		listarPorGenero(Genre.Misc);
	}
}
