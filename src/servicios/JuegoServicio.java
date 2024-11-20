package servicios;

import datos.JuegoDato;

/**
 * Clase JuegoServicio
 * Maneja la lógica 
 * 19/11/2024
 * @version 1.1
 * @author raul_
 * Fecha: 20/11/2014
 */

public class JuegoServicio {
	
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
