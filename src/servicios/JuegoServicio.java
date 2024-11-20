package servicios;

import datos.JuegoDato;
import java.util.List;
import modelos.Genre;
import modelos.Juego;

/**
 * Clase JuegoServicio
 * Descripción... 
 * 19/11/2024
 * Versión 1
 * Raúl
 */

public class JuegoServicio {

    private JuegoDato datos = new JuegoDato();

    public List<Juego> listarJuegos(){
        return datos.listarJuegos();
    }
	
	/**
     * Redirecciona a datos para filtrar los juegos cargados en la clase por un género específico.
     */
    public List<Juego> listarPorGenero(Genre genero) {
        return datos.listarPorGenero(genero);
    }

}
