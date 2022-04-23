package clases;

import java.util.Scanner;

public class Usuario {


	private String run;
	private String nombreCompleto;
	private String genero;
	private String prestamo;
	
	public Usuario(String run, String nombreCompleto, String genero, String prestamo) {
		this.setRun(run);
		this.nombreCompleto = nombreCompleto;
		this.setGenero(genero);
		this.prestamo = prestamo;
	}


	public String getRun() {
		return run;
	}

	public void setRun(String run) { 
        this.run = run.toUpperCase();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int largoRun =  this.run.length();
            if (largoRun == 10) {
                if (this.run.charAt(8) == '-'){
                    char verificador = this.run.charAt(9);
                    if (verificador == '0' || verificador == '1' || verificador == '2' || verificador == '3' || verificador == '4' || verificador == '5' || verificador == '6' || verificador == '7' || verificador == '8' || verificador == '9' || verificador == 'K'){
                        break;
                    }
                }
           }
            
            System.out.println("El run ingresado no es valido, ingrese nuevamente: ");
            this.run = scanner.nextLine().toUpperCase();
            System.out.println("El run ingrsado es: " + this.run);
        }
        
    }

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero.toUpperCase();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (this.genero.equals("M") || this.genero.equals("F")) {
				break;
			}

			System.out.println("El gEnero debe ser \"M\" o \"F\". Ingresalo nuevamente:");
			this.genero = scanner.nextLine().toUpperCase();;
			
		}
		
	}

	public String getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}

	public String rawData() {
		return this.run +";"+ this.nombreCompleto +";"+ this.genero +";"+ this.prestamo;
	}

	public String orderedData() {
		String libroPrestadoData;
		if (this.prestamo.equals("0")) {
			libroPrestadoData = "Ninguno";
		} else {
			libroPrestadoData = this.prestamo;
		}

		return ""
				+ "Run: " + this.run + "\n"
				+ "Nombre completo: " + this.nombreCompleto + "\n"
				+ "Genero: " + this.genero + "\n"
				+ "Libro prestado: " + libroPrestadoData;
	}

}
