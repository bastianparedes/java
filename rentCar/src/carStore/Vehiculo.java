package carStore;
import java.util.Scanner;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int year;
    private String condicion = "D";

    public Vehiculo(int year) {
    	Scanner scanner = new Scanner(System.in);
    	this.patente = pedirAtributoEnMayusculas("Por favor introduzca la patente del vehiculo en mayusculas:");
    	this.marca = pedirAtributoEnMayusculas("Por favor introduzca la marca del vehiculo en mayusculas:");
    	this.modelo = pedirAtributoEnMayusculas("Por favor introduzca el modelo del vehiculo en mayusculas:");
        this.year = year;
    }

    public String getPatente() {
        return this.patente;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getYear() {
        return this.year;
    }

    public String getCondicion() {
        return this.condicion;
    }

    public void setCondicion(String nuevaCondicion) {
    	while (nuevaCondicion != "D" && nuevaCondicion != "A" && nuevaCondicion != "M") {
    		Scanner scanner = new Scanner(System.in);
    		System.out.println ("Solo se aceptan los valores \"D\", \"A\" y \"M\"");
    		nuevaCondicion = scanner.nextLine();
    	}
    	this.condicion = nuevaCondicion;
    }


    
    
    private String pedirAtributoEnMayusculas(String mensaje) {
    	Scanner scanner = new Scanner(System.in);
    	String valor;
    	
    	while (true) {
    		System.out.println (mensaje);
            valor = scanner.nextLine();

            if (valor.equals(valor.toUpperCase())) {
            	return valor;
            }
    	}
    }

    
    
    
}