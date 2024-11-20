package servicios;

import datos.JuegoDato;

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

	
	private JuegoDato juegoDato;
	
	// Constructor
	public JuegoServicio() {
		this.juegoDato = new JuegoDato();
	}
	
	public boolean listarJuegos() {
		System.out.println("Listado de Juegos: ");
		return JuegoDato.listarJuegos();
	}
		
}
