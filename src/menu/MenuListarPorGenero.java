package menu;

import modelos.Juego.Genre;
import servicios.JuegoServicio;
import utilidades.LeerTeclado;

import java.util.List;
import java.util.logging.Logger;

/**
 * Clase MenuListarPorGenero.
 * Se encarga de mostrar los juegos filtrados por género.
 * @version 1.1
 * @author kikev
 * Fecha: 20/11/2024
 */
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
            List<String> juegos = juegoServicio.listarPorGenero(generoSeleccionado);

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
}
