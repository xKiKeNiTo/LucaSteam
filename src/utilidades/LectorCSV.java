package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para leer archivos CSV.
 * @version 1.1
 */
public class LectorCSV {

    private static List<List<String>> juegos;

    // Constructor
    public LectorCSV() {
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
     * @return Lista de listas representando las filas del CSV.
     */
    public List<List<String>> getJuegos() {
        return juegos;
    }

    /**
     * Método principal para probar la lectura de un archivo CSV.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        LectorCSV lector = new LectorCSV();
        String filePath = "vgsales.csv"; // Ruta del archivo CSV

        try {
            lector.leerCSV(filePath); // Leer el archivo y llenar la lista
            List<List<String>> contenido = lector.getJuegos();

            // Imprimir el contenido
//            for (List<String> fila : contenido) {
//                System.out.println(fila);
//            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
