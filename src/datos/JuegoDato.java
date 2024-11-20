package datos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelos.Juego;
import modelos.Platform;
import modelos.Genre;
import utilidades.LectorCSV;

/**
 * Clase JuegoDato
 * Descripción... 
 * 19/11/2024
 * @version 1
 * @author raul_
 */

public class JuegoDato {
	
	public boolean listarJuegos() {
		LectorCSV lector = new LectorCSV();
		String filePath = "vgsales.csv";
		
		try {
			lector.leerCSV(filePath);
			List<List<String>> datos = lector.getJuegos();
			
			if (datos.isEmpty()) {
				System.out.println("CSV sin datos");
				return false;
			}
			
			List<Juego> juegos = convertirAObjetoJuego(datos);
			System.out.println("Juegos desde datos: ");
			for (Juego juego : juegos) {
				System.out.println(juego);
			}
			return true;
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo CSV en datos: " + e.getMessage());
			return false;
		}		
	}
	
	private List<Juego> convertirAObjetoJuego(List<List<String>> datos) {
		List<Juego> juegos = new ArrayList<>();
		
			// La primera fila contiene encabezados -> la ignoramos
			for (int i = 1; i < datos.size(); i++) {
				List<String> fila = datos.get(i);
				
				try {
					
					int rank = Integer.parseInt(fila.get(0)); // Convertir a int
		            String nombre = fila.get(1); // Es String, no necesita conversión
		            Platform platform = Platform.valueOf(fila.get(2).toUpperCase()); // Enum
		            int year = Integer.parseInt(fila.get(3)); // Convertir a int
		            Genre genre = Genre.valueOf(fila.get(4).toUpperCase()); 
		            String publisher = fila.get(5);
		            double naSales = Double.parseDouble(fila.get(6)); // Convertir a double
		            double euSales = Double.parseDouble(fila.get(7));
		            double jpSales = Double.parseDouble(fila.get(8));
		            double otherSales = Double.parseDouble(fila.get(9));
		            double globalSales = Double.parseDouble(fila.get(10));
					
					juegos.add(new Juego(rank, nombre, platform, year, genre, publisher, naSales, euSales, jpSales, otherSales, globalSales));			
				
				} catch (Exception e) {
	                System.err.println("Error al convertir una fila a objeto Juego: " + e.getMessage());
	            }
				
			}
		return juegos;
	}

}
