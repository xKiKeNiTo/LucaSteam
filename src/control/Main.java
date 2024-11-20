package control;

import menu.MenuPrincipal;

/**
 * Clase principal para iniciar la aplicación.
 * @version 1.0
 * @author kikev
 * Fecha: 20/11/2024
 */
public class Main {

    public static void main(String[] args) {
        boolean menuExitoso = MenuPrincipal.mostrarMenu();

        if (menuExitoso) {
            System.out.println("El programa finalizó correctamente.");
        } else {
            System.err.println("Hubo un problema durante la ejecución del programa.");
        }
    }
}