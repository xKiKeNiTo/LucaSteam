package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class lectorCSV {

    private List<List<String>> juegos;

    // Constructor
    public lectorCSV() {
        this.juegos = new ArrayList<>();
    }
    
    public void leerCSV(String filePath) throws IOException {
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
    public static List<List<String>> getJuegos() {
        return juegos;
    }

    // public static void main(String[] args) {
    //     lectorCSV lector = new lectorCSV();
    //     String filePath = "vgsales.csv";

    //     try {
    //         lector.leerCSV(filePath); // Leer el archivo y llenar la lista
    //         List<List<String>> contenido = lector.getJuegos();

    //         // Imprimir el contenido
            
    //         for (List<String> fila : contenido) {
    //             System.out.println(fila);
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Error al leer el archivo CSV: " + e.getMessage());
    //     }
    // }
}
