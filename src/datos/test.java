package datos;

import java.io.IOException;
import java.util.List;
import modelos.Juego;
import utilidades.LectorCSV;

public class test {
    // public boolean listarPorGenero(String genero){
    //     boolean existen = false;
    //     LectorCSV lector = new LectorCSV();
    //     List<List<String>> juegos = lector.getJuegos();
    //     try {
    //         existen = !juegos.isEmpty();
    //     } catch (Exception e) {
    //         System.out.println("Error"+e.getMessage());
    //     }
        
    //     return existen;
    // }

    public static void main(String[] args){
        try {
            // Crear una instancia de LectorCSV
            LectorCSV lector = new LectorCSV();

            // Leer el archivo CSV
            lector.leerCSV();  // Este método lee las líneas del archivo

            // Obtener la lista de juegos, procesando las líneas leídas
            List<Juego> juegos = lector.getJuegos();

            // Imprimir los juegos
            for (Juego juego : juegos) {
                System.out.println(juego);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los juegos: " + e.getMessage());
        }
    }
}
