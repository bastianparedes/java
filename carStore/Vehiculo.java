package carStore;
import java.util.Scanner;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int year;
    private String condicion = "D";

    public Vehiculo(String patente, String marca, String modelo, int year, String condicion) {
        this.patente = patente.toUpperCase();
        this.marca = marca.toUpperCase();
        this.modelo = modelo.toUpperCase();
        this.year = year;
        this.condicion = condicion.toUpperCase();
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
        this.condicion = nuevaCondicion;
    }


    public void mostrarInformacion() {
        System.out.println(
            "Patente: " + this.patente + "\n"
             + "    " + "Marca: " + this.marca + "\n"
             + "    " + "Modelo: " + this.modelo + "\n"
             + "    " + "Año: " + this.year + "\n"
             + "    " + "Condición: " + this.condicion + "\n"
        );
    }
    
    
}