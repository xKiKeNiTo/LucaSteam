package utilidades;

import java.util.Scanner;

public class LeerTeclado {

	@SuppressWarnings("resource")
	public static String leerLinea() {
		return new Scanner(System.in).nextLine();
	}

	public static String leerLinea(String mensaje) {
		System.out.println(mensaje);
		return leerLinea();
	}

	@SuppressWarnings("resource")
	public static int leerInt() {
		return new Scanner(System.in).nextInt();
	}

	public static int leerInt(String mensaje) {
		System.out.println(mensaje);
		return leerInt();
	}

	@SuppressWarnings("resource")
	public static short leerShort() {
		return new Scanner(System.in).nextShort();
	}

	public static short leerShort(String mensaje) {
		System.out.println(mensaje);
		return leerShort();
	}

	@SuppressWarnings("resource")
	public static float leerFloat() {
		return new Scanner(System.in).nextFloat();
	}

	public static float leerFloat(String mensaje) {
		System.out.println(mensaje);
		return leerFloat();
	}

	@SuppressWarnings("resource")
	public static long leerLong() {
		return new Scanner(System.in).nextLong();
	}

	public static long leerLong(String mensaje) {
		System.out.println(mensaje);
		return leerLong();
	}

	@SuppressWarnings("resource")
	public static double leerDouble() {
		return new Scanner(System.in).nextDouble();
	}

	public static double leerDouble(String mensaje) {
		System.out.println(mensaje);
		return leerDouble();
	}

	@SuppressWarnings("resource")
	public static byte leerByte() {
		return new Scanner(System.in).nextByte();
	}

	public static byte leerByte(String mensaje) {
		System.out.println(mensaje);
		return leerByte();
	}

	@SuppressWarnings("resource")
	public static String leerPalabra() {
		return new Scanner(System.in).next();
	}

	public static String leerPalabra(String mensaje) {
		System.out.println(mensaje);
		return leerPalabra();
	}

}
