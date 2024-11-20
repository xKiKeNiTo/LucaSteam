package modelos;

/**
 * Clase Juego
 * Modelo para los objetos de tipo Juego con los atributos, getters, setters y toString 
 * 19/11/2024
 * Versión 1
 * Raúl
 */

public class Juego {
	private int rank;
	private String name;
	private int year;
	private String publisher;
	private double naSales;
	private double euSales;
	private double jpSales;
	private double otherSales;
	private double globalSales;
	private Platform platform;
	private Genre genre;

	// Getters & Setters
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getNaSales() {
		return naSales;
	}

	public void setNaSales(double naSales) {
		this.naSales = naSales;
	}

	public double getEuSales() {
		return euSales;
	}

	public void setEuSales(double euSales) {
		this.euSales = euSales;
	}

	public double getJpSales() {
		return jpSales;
	}

	public void setJpSales(double jpSales) {
		this.jpSales = jpSales;
	}

	public double getOtherSales() {
		return otherSales;
	}

	public void setOtherSales(double otherSales) {
		this.otherSales = otherSales;
	}

	public double getGlobalSales() {
		return globalSales;
	}

	public void setGlobalSales(double globalSales) {
		this.globalSales = globalSales;
	}
	
	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	};

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	};

	// Contructores
	public Juego(int rank, String name, int year, String publisher, double naSales, double euSales, double jpSales,
			double otherSales, double globalSales, Platform platform, Genre genre) {
		super();
		this.rank = rank;
		this.name = name;
		this.year = year;
		this.publisher = publisher;
		this.naSales = naSales;
		this.euSales = euSales;
		this.jpSales = jpSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;	
		this.platform = platform;
		this.genre = genre;
		}

	public Juego() {
		super();
	}
	
	// toString
	@Override
	public String toString() {
		return "Juego [rank=" + rank + 
				", name=" + name + 
				", year=" + year + 
				", publisher=" + publisher + 
				", platform=" + platform + 
				", genre=" + genre + 
				", naSales=" + naSales + 
				", euSales=" + euSales + 
				", jpSales=" + jpSales + 
				", otherSales=" + otherSales + 
				", globalSales=" + globalSales + 				
				"]";
	}
			     
}
