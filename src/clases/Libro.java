package clases;

import java.util.Scanner;

public class Libro {

	private String ISBN;
	private String titulo;
	private String autor;
	private int cantidadEnBiblioteca;
	private int cantidadDisponiblePrestamo;

	public Libro(String ISBN, String titulo, String autor, int cantidadEnBiblioteca, int cantidadDisponiblePrestamo) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		
		this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
		this.setCantidadEnBiblioteca(cantidadEnBiblioteca);
		
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCantidadEnBiblioteca() {
		return cantidadEnBiblioteca;
	}

	public void setCantidadEnBiblioteca(int cantidadEnBiblioteca) {
		this.cantidadEnBiblioteca = cantidadEnBiblioteca;
		
		Scanner scanner = new Scanner(System.in);
        while (true) {
        	if (this.cantidadEnBiblioteca < 1) {
        		System.out.println("La cantidad disponible en biblioteca no puede ser menor o igual a 0");
        	} else if (this.cantidadEnBiblioteca < this.cantidadDisponiblePrestamo) {
        		System.out.println("La cantidad disponible en biblioteca (" + this.cantidadEnBiblioteca + ") no puede ser menor que la cantidad disponible para prestar(" + this.cantidadDisponiblePrestamo + ")");
        	} else {
        		break;
        	}

        	System.out.println("Ingresa la cantidad disponible en biblioteca:");
        	String cantidadEnBibliotecaString = scanner.nextLine();
        	try {
                this.cantidadEnBiblioteca = Integer.parseInt(cantidadEnBibliotecaString);
        	} catch (Exception ex) {
        		System.out.println("Ingresaste algo que no es un numero");
        	}	
        }

	}

	public int getCantidadDisponiblePrestamo() {
		return cantidadDisponiblePrestamo;
	}

	public void setCantidadDisponiblePrestamo(int cantidadDisponiblePrestamo) {
		this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
	}



	public String rawData() {
		return this.ISBN +";"+ this.titulo +";"+ this.autor +";"+ this.cantidadEnBiblioteca +";"+ this.cantidadDisponiblePrestamo;
	}
	
	public String orderedData() {
		return ""
				+ "Run: " + this.ISBN + "\n"
				+ "Nombre completo: " + this.titulo+ "\n"
				+ "Genero: " + this.autor + "\n"
				+ "Cantidad disponible en biblioteca: " + this.cantidadEnBiblioteca + "\n"
				+ "Cantidad disponible para prestar: " + this.cantidadDisponiblePrestamo;
	}
	
	
}


