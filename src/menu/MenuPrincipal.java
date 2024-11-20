package menu;

import java.util.logging.Logger;
import utilidades.LeerTeclado;

/**
 * Clase MenuPrincipal.
 * Se encarga de gestionar el menú principal de la aplicación, permitiendo al usuario navegar entre opciones.
 * @version 1.1
 * @author kikev
 * Fecha: 20/11/2024
 */
public class MenuPrincipal {

    private static final Logger logger = Logger.getLogger(MenuPrincipal.class.getName());

    /**
     * Muestra el menú principal y gestiona la navegación entre opciones.
     * @return true si el menú se ejecuta correctamente, false en caso de error.
     */
    public static boolean mostrarMenu() {
        try {
            boolean salir = false;

            while (!salir) {
                System.out.println("==== Menú Principal ====");
                System.out.println("1. Dar de alta un juego");
                System.out.println("2. Listar todos los juegos");
                System.out.println("3. Listar juegos por género");
                System.out.println("4. Salir");

                int opcion = LeerTeclado.leerInt("Seleccione una opción:");

                switch (opcion) {
                    // case 1 -> {
                    //     logger.info("Seleccionada opción 1: Dar de alta un juego");
                    //     boolean altaExitosa = FormularioAlta.darDeAlta();
                    //     if (!altaExitosa) {
                    //         logger.warning("La operación de alta falló.");
                    //     }
                    // }
                    // case 2 -> {
                    //     logger.info("Seleccionada opción 2: Listar todos los juegos");
                    //     boolean listadoExitoso = MenuListarJuegos.listarJuegos();
                    //     if (!listadoExitoso) {
                    //         logger.warning("El listado de juegos falló.");
                    //     }
                    // }
                    case 3 -> {
                        logger.info("Seleccionada opción 3: Listar juegos por género");
                        boolean listadoPorGeneroExitoso = MenuListarPorGenero.listarPorGenero();
                        if (!listadoPorGeneroExitoso) {
                            logger.warning("El listado de juegos por género falló.");
                        }
                    }
                    case 4 -> {
                        logger.info("Seleccionada opción 4: Salir");
                        salir = true;
                    }
                    default -> {
                        logger.warning("Opción inválida seleccionada");
                        System.out.println("Opción inválida, intente nuevamente.");
                    }
                }
            }
            return true; // Si el menú se navegó correctamente, retorna true
        } catch (Exception e) {
            logger.severe("Error en el menú principal: " + e.getMessage());
            System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
            return false; // En caso de error, retorna false
        }
    }
}