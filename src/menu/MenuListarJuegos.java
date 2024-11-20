package menu;

import servicios.JuegoServicio;

import java.util.List;
import java.util.logging.Logger;

/**
 * Clase MenuListarJuegos.
 * Se encarga de listar todos los juegos registrados en el sistema.
 * @version 1.1
 * @author kikev
 * Fecha: 20/11/2024
 */
public class MenuListarJuegos {

    private static final Logger logger = Logger.getLogger(MenuListarJuegos.class.getName());
    private static final JuegoServicio servicio = new JuegoServicio();

    /**
     * Método para listar todos los juegos registrados.
     * @return true si el listado se realizó correctamente, false en caso de error.
     */
    public static boolean listarJuegos() {
        try {
            logger.info("Iniciando listado de todos los juegos registrados.");
            System.out.println("Listado de todos los juegos registrados:");

            // Llama al servicio para obtener todos los juegos
            // List<String> juegos = servicio.listarJuegos();

            // Muestra los juegos o indica si no hay registros
            if (juegos.isEmpty()) {
                logger.info("No se encontraron juegos registrados.");
                System.out.println("No hay juegos registrados.");
            } else {
                logger.info("Se encontraron " + juegos.size() + " juegos registrados.");
                juegos.forEach(System.out::println);
            }
            return true; // Operación exitosa
        } catch (Exception e) {
            logger.severe("Error al listar todos los juegos: " + e.getMessage());
            System.err.println("Ocurrió un error al listar los juegos: " + e.getMessage());
            return false; // Indica que hubo un error en la operación
        }
    }
}
