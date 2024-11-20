package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Clase para las utilidades del CSV 20/11/2024
 * 
 * @version 1.1
 * @author kikev e ivan
 */
public class CSV {

	public static File fichero = new File("./vgsales.csv");

	private static final Logger log = Logger.getLogger(CSV.class.getName());

	private static List<List<String>> juegos;

	// Constructor
	public CSV() {
		this.juegos = new ArrayList<>();
	}

	/**
	 * Método para leer un archivo CSV y cargarlo en una lista de listas.
	 * 
	 */
	public static void leerCSV(String filePath) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] valores = linea.split(","); // Dividir por comas
				List<String> fila = new ArrayList<>();
				for (String valor : valores) {
					fila.add(valor.trim()); // Agregar cada valor a la fila
				}
				juegos.add(fila); // Agregar la fila a la lista de juegos
			}
		}
	}

	/**
	 * Obtener los juegos leídos del archivo CSV.
	 * 
	 * @return Lista de listas representando las filas del CSV.
	 */
	public List<List<String>> getJuegos() {
		return juegos;
	}

	/**
	 * Metodo para guardar, añadiendo, una lista de objetos genericos, comun para
	 * Juegos, Generos, Plataformas...
	 * 
	 * @param <T>     objeto generico
	 * @param objetos Lista de objetos generica, si se quiere añadir uno solo, se ha
	 *                de meter en una lista de un solo objeto
	 * @param f       objeto que hace referencia al fichero CSV, en este caso,
	 *                estatico en la clase CSV
	 * @return true si se ha conseguido hacer con exito, false si no
	 */
	public static <T> boolean guardarCSV(List<T> objetos, File f) {

		if (objetos == null || objetos.isEmpty()) {
			System.err.println("No hay objetos para guardar");
			log.warning("No hay objetos para guardar");
			return false;
		}

		try (FileWriter fw = new FileWriter(f, true)) { // "true" añade el contenido y no lo sobreescribe
			// Escribir encabezado
			Class<?> clase = objetos.get(0).getClass(); // Obtener la clase del primer objeto
			Field[] campos = clase.getDeclaredFields(); // Obtener los campos de la clase

			if (!f.exists()) {

				// Escribir nombres de los campos como encabezado
				for (int i = 0; i < campos.length; i++) {
					fw.write(campos[i].getName());
					if (i < campos.length - 1) {
						fw.write(",");
					}
				}
				fw.write("\n");

			}

			// Escribir los valores de los objetos
			for (T objeto : objetos) {
				for (int i = 0; i < campos.length; i++) {
					campos[i].setAccessible(true); // Permitir acceso a campos privados
					Object valor = campos[i].get(objeto); // Obtener el valor del campo
					fw.write(valor != null ? valor.toString() : ""); // Manejar valores nulos
					if (i < campos.length - 1) {
						fw.write(",");
					}
				}
				fw.write("\n");
			}

			System.out.println("Archivo CSV guardado exitosamente");
			log.info("Archivo CSV guardado exitosamente");
			return true;

		} catch (IOException | IllegalAccessException e) {

			System.err.println("Error al guardar el CSV: " + e.getMessage());
			log.warning("Error al guardar el CSV");
			return false;

		}

	}

}
