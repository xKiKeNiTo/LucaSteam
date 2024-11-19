package modelos;

public class Juego {
	private int rank;
	private String name;
//	private enum platform {WII, NES, GB, DS, X360, PS3, PS2, SNES, GBA, PS4, PS, _3DS, _2600, GC, WIIU, XB, PC, GEN, N64, XONE, PSP};
	private int year;
//	private enum genre {};
	private String publisher;
	private double naSales;
	private double euSales;
	private double jpSales;
	private double otherSales;
	private double globalSales;
	
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
	
	// Contructores	
	public Juego(int rank, String name, int year, String publisher, double naSales, double euSales, double jpSales,
			double otherSales, double globalSales) {
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
	}
	
	public Juego() {
		super();
	}
	
	@Override
	public String toString() {
		return "Juego [rank=" + rank + ", name=" + name + ", year=" + year + ", publisher=" + publisher + ", naSales="
				+ naSales + ", euSales=" + euSales + ", jpSales=" + jpSales + ", otherSales=" + otherSales
				+ ", globalSales=" + globalSales + "]";
	}
	
	
		
}
