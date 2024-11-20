package datos;

import java.util.ArrayList;
import java.util.List;
import modelos.Genre;
import modelos.Juego;
import utilidades.LectorCSV;

/**
 * Clase JuegoDato
 * Descripción... 
 * 19/11/2024
 * Versión 1
 * Raúl
 */

public class JuegoDato {

	private static LectorCSV lector = new LectorCSV();
	private static List<Juego> juegos;

	// public static boolean listarJuegos() {
		
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
