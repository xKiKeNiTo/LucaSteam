package menu;

import java.util.List;
import java.util.logging.Logger;
import modelos.Genre;
import modelos.Juego;
import servicios.JuegoServicio;
import utilidades.LeerTeclado;

public class MenuListarPorGenero {
    private static final Logger logger = Logger.getLogger(MenuListarPorGenero.class.getName());
    private static final JuegoServicio juegoServicio = new JuegoServicio();

    /**
     * Método para listar los juegos filtrados por género.
     * @return true si el listado se realizó correctamente, false en caso de error.
     */
    public static boolean listarPorGenero() {
        try {
            logger.info("Iniciando listado de juegos por género.");
            System.out.println("Listado de juegos por género:");

            // Mostrar opciones de géneros
            Genre[] generos = Genre.values();
            for (int i = 0; i < generos.length; i++) {
                System.out.println((i + 1) + ". " + generos[i]);
            }

            // Pedir selección
            int opcion = LeerTeclado.leerInt("Seleccione un género (1-" + generos.length + "):");
            while (opcion < 1 || opcion > generos.length) {
                logger.warning("Selección de género inválida: " + opcion);
                System.out.println("Opción inválida. Intente nuevamente.");
                opcion = LeerTeclado.leerInt("Seleccione un género (1-" + generos.length + "):");
            }

            // Obtener el género seleccionado
            Genre generoSeleccionado = generos[opcion - 1];
            logger.info("Género seleccionado: " + generoSeleccionado);

            // Llamar al servicio para obtener la lista de juegos por género
            List<Juego> juegos = juegoServicio.listarPorGenero(generoSeleccionado);

            // Mostrar resultados
            if (juegos.isEmpty()) {
                logger.info("No hay juegos registrados en el género " + generoSeleccionado);
                System.out.println("No hay juegos registrados en el género " + generoSeleccionado + ".");
            } else {
                logger.info("Mostrando juegos del género " + generoSeleccionado);
                System.out.println("Juegos del género " + generoSeleccionado + ":");
                juegos.forEach(System.out::println);
            }
            return true; // Indica que la operación se realizó correctamente
        } catch (Exception e) {
            logger.severe("Error al listar juegos por género: " + e.getMessage());
            System.err.println("Ocurrió un error al listar los juegos: " + e.getMessage());
            return false; // Indica que hubo un error en la operación
        }
    }
    // public static void mostrarMenu() {

	// 	boolean salir = false;
    //     LectorCSV lector = new LectorCSV();

    //     // Cargar datos desde el archivo CSV
    //     List<Juego> juegos;
    //     try {
    //         lector.leerCSV();
    //         juegos = lector.getJuegos();
    //     } catch (IOException e) {
    //         System.err.println("Error al leer el archivo CSV: " + e.getMessage());
    //         return;
    //     }
		
    //     while(!salir){
    //         System.out.println("==== Listar juegos por género ====");

    //         System.out.println("Géneros disponibles:");
            
    //         // Mostrar los géneros disponibles
    //         for (Genre genero : Genre.values()) {
    //             System.out.println("- " + genero);
    //         }
            
    //         //Pido genero al usuario
    //         String palabra = LeerTeclado.leerPalabra("Introduzca un genero de los siguientes");
            

    //         try {
    //             // Validar y convertir el input del usuario a un enum Genre
    //             Genre generoSeleccionado = Genre.valueOf(palabra);

    //             // Filtrar juegos por género
    //             List<Juego> juegosFiltrados = filtrarPorGenero(juegos, generoSeleccionado);

    //             if (juegosFiltrados.isEmpty()) {
    //                 System.out.println("No se encontraron juegos para el género: " + generoSeleccionado);
    //             } else {
    //                 System.out.println("Juegos encontrados para el género " + generoSeleccionado + ":");
    //                 for (Juego juego : juegosFiltrados) {
    //                     System.out.println(juego);
    //                 }
    //                 salir = true;
    //             }

    //         } catch (IllegalArgumentException e) {
    //             System.out.println("El género ingresado no es válido. Intenta de nuevo.");
    //         }
    //     }
	// }

    // /**
    //  * Filtra una lista de juegos por un género específico.
    //  *
    //  * @param juegos La lista de juegos a filtrar.
    //  * @param genero El género por el cual filtrar.
    //  * @return Una lista de juegos que corresponden al género proporcionado.
    //  */
    // public static List<Juego> filtrarPorGenero(List<Juego> juegos, Genre genero){
    //     List<Juego> juegosFiltrados = new ArrayList<>();
    //     for (Juego juego : juegos) {
    //         if (juego.getGenre() == genero) {
    //             juegosFiltrados.add(juego);
    //         }
    //     }
    //     return juegosFiltrados;
    // }

    /**
     * Método principal para testear la funcionalidad.
     */
    public static void main(String[] args) {
        listarPorGenero();
    }
}
