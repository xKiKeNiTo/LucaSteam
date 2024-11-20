package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelos.Genre;
import modelos.Juego;
import modelos.Platform;

/**
 * Clase para leer archivos CSV.
 * @version 1.1
 */
public class LectorCSV {

    private final static String filePath = "vgsales.csv";
    private List<String> lineasCSV;
    
    // Constructor
    public LectorCSV() {
        this.lineasCSV = new ArrayList<>();
    }

    /**
     * Método para leer un archivo CSV y cargarlo en una lista de listas.
     * 
     */
    public void leerCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            boolean primeraLinea = true; // Para saltar el encabezado

            while ((linea = br.readLine()) != null) {
                // Saltar la primera línea (encabezado)
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                lineasCSV.add(linea.trim());  // Almacenar solo las líneas de datos
            }
        }
    }

    /**
     * Obtener los juegos leídos del archivo CSV.
     * @return Lista de listas representando las filas del CSV.
     */
    public List<Juego> getJuegos() {
        List<Juego> juegos = new ArrayList<>();

        // Convertir cada línea en un objeto Juego
        for (String linea : lineasCSV) {
            String[] valores = linea.split(",");
            try {
                int rank = Integer.parseInt(valores[0].trim());
                String name = valores[1].trim();
                Platform platform = Platform.valueOf(valores[2].trim());
                int year = Integer.parseInt(valores[3].trim());
                Genre genre = Genre.valueOf(valores[4].trim());
                String publisher = valores[5].trim();
                double naSales = Double.parseDouble(valores[6].trim());
                double euSales = Double.parseDouble(valores[7].trim());
                double jpSales = Double.parseDouble(valores[8].trim());
                double otherSales = Double.parseDouble(valores[9].trim());
                double globalSales = Double.parseDouble(valores[10].trim());

                // Crear objeto Juego
                Juego juego = new Juego(rank, name, year, publisher, naSales, euSales, jpSales,
                                        otherSales, globalSales, platform, genre);

                juegos.add(juego);

            } catch (IllegalArgumentException e) {
                System.err.println("Error al procesar línea: " + linea + " -> " + e.getMessage());
            }
        }

        return juegos; 
    }

    // Método main para probar la funcionalidad
    public static void main(String[] args) {
        LectorCSV lector = new LectorCSV();
        
        try {
            // Leer el archivo CSV y cargar las líneas
            lector.leerCSV();
            
            // Obtener la lista de juegos
            List<Juego> juegos = lector.getJuegos();
            
            // Imprimir la lista de juegos
            for (Juego juego : juegos) {
                System.out.println(juego);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
