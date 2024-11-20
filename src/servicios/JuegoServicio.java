package servicios;

import datos.JuegoDato;
import java.util.List;
import modelos.Genre;
import modelos.Juego;


/**
 * Clase JuegoServicio
 * Maneja la lógica 
 * 19/11/2024
 * @version 1.1
 * @author raul_
 * Fecha 20/11/2014
 */

public class JuegoServicio {

    private JuegoDato juegoDato = new JuegoDato();

	// Constructor
	public JuegoServicio() {
		this.juegoDato = new JuegoDato();
	}
	
	public boolean listarJuegos() {
		System.out.println("Listado de Juegos: ");
		return JuegoDato.listarJuegos();
	}
	
	/**
     * Redirecciona a datos para filtrar los juegos cargados en la clase por un género específico.
     */
    public List<Juego> listarPorGenero(Genre genero) {
        return juegoDato.listarPorGenero(genero);
    }
    /*
	 * Metodo que redirecciona la accion al paquete de datos
	 * @param j es el objeto Juego que recibimos y enviamos
	 * @return true si se completa, false si no
	 */
	public boolean darDeAlta(Juego j) {
		
		if (JuegoDato.darDeAlta(j)) return true;
		
		return false;
	}
		
}
