package menu;

import modelos.Juego;
import modelos.Platform;
import modelos.Genre;
import servicios.JuegoServicio;
import utilidades.LeerTeclado;

import java.util.logging.Logger;

/**
 * Clase FormularioAlta.
 * Se encarga de gestionar el formulario para dar de alta un nuevo juego.
 * @version 1.0
 * @author kikev
 * Fecha: 20/11/2024
 */
public class FormularioAlta {

    private static final Logger logger = Logger.getLogger(FormularioAlta.class.getName());
    private static final JuegoServicio juegoServicio = new JuegoServicio();

    /**
     * Método para mostrar el formulario y dar de alta un nuevo juego.
     * @return true si el juego se da de alta correctamente, false en caso de error.
     */
    public static boolean darDeAlta() {
        try {
            logger.info("Iniciando el formulario de alta de juego.");
            System.out.println("Formulario para dar de alta un nuevo juego:");

            int rank = LeerTeclado.leerInt("Ingrese el ranking del juego:");
            String name = LeerTeclado.leerLinea("Ingrese el nombre del juego:");
            int year = LeerTeclado.leerInt("Ingrese el año de lanzamiento:");
            String publisher = LeerTeclado.leerLinea("Ingrese el editor del juego:");
            double naSales = LeerTeclado.leerDouble("Ingrese las ventas en Norteamérica (en millones):");
            double euSales = LeerTeclado.leerDouble("Ingrese las ventas en Europa (en millones):");
            double jpSales = LeerTeclado.leerDouble("Ingrese las ventas en Japón (en millones):");
            double otherSales = LeerTeclado.leerDouble("Ingrese las ventas en otras regiones (en millones):");
            double globalSales = naSales + euSales + jpSales + otherSales;

            Platform platform = seleccionarPlataforma();
            if (platform == null) {
                logger.warning("Se canceló la selección de la plataforma.");
                return false;
            }

            Genre genre = seleccionarGenero();
            if (genre == null) {
                logger.warning("Se canceló la selección del género.");
                return false;
            }

            Juego juego = new Juego(rank, name, year, publisher, naSales, euSales, jpSales, otherSales, globalSales, platform, genre);
            juegoServicio.darDeAlta(juego);

            logger.info("Juego dado de alta correctamente: " + name);
            return true;
        } catch (Exception e) {
            logger.severe("Error al dar de alta el juego: " + e.getMessage());
            System.err.println("Error al dar de alta el juego: " + e.getMessage());
            return false;
        }
    }

    private static Platform seleccionarPlataforma() {
        System.out.println("Seleccione la plataforma del juego:");
        Platform[] plataformas = Platform.values();
        for (int i = 0; i < plataformas.length; i++) {
            System.out.println((i + 1) + ". " + plataformas[i]);
        }
        System.out.println((plataformas.length + 1) + ". Salir");

        int opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + plataformas.length + "):");
        while (opcion < 1 || opcion > plataformas.length + 1) {
            logger.warning("Opción inválida seleccionada en plataformas: " + opcion);
            System.out.println("Opción inválida. Intente de nuevo.");
            opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + plataformas.length + "):");
        }

        if (opcion == plataformas.length + 1) {
            System.out.println("Saliendo de la selección de plataforma.");
            return null;
        }

        return plataformas[opcion - 1];
    }

    private static Genre seleccionarGenero() {
        System.out.println("Seleccione el género del juego:");
        Genre[] generos = Genre.values();
        for (int i = 0; i < generos.length; i++) {
            System.out.println((i + 1) + ". " + generos[i]);
        }
        System.out.println((generos.length + 1) + ". Salir");

        int opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + (generos.length + 1) + "):");
        while (opcion < 1 || opcion > generos.length + 1) {
            logger.warning("Opción inválida seleccionada en géneros: " + opcion);
            System.out.println("Opción inválida. Intente de nuevo.");
            opcion = LeerTeclado.leerInt("Seleccione una opción (1-" + (generos.length + 1) + "):");
        }

        if (opcion == generos.length + 1) {
            System.out.println("Saliendo de la selección de género.");
            return null;
        }

        return generos[opcion - 1];
    }
}
