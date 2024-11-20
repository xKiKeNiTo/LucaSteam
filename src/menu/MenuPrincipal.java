package menu;

import utilidades.LeerTeclado;

/**
 * Menú principal.
 * @version 1.0
 */

public class MenuPrincipal {

	public static void mostrarMenu() {
		boolean salir = false;
		
		while (!salir) {
			System.out.println("==== Menú Principal ====");
            System.out.println("1. Dar de alta un juego");
            System.out.println("2. Listar todos los juegos");
            System.out.println("3. Listar juegos por género");
            System.out.println("4. Salir");
            int opcion = LeerTeclado.leerInt("Seleccione una opción:");
            
            switch (opcion) {
			case 1 -> FormularioAlta.darDeAlta();
			case 2 -> MenuListarJuegos.listarJuegos();
			case 3 -> MenuListarPorGenero.listarPorGenero();
			case 4 -> salir = true;
			default -> System.out.println("Opción inválida, intente nuevamente.");
			}
            
		}
		
	}
	
}

