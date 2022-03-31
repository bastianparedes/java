package carStore;
import java.time.LocalDate;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

public class Arriendo {
    private int numero;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private int duracionDias;
    private int precioDiario;
    private boolean arriendoTerminado = false;
    private int monto;


    public Arriendo(int numero, Cliente cliente, Vehiculo vehiculo, LocalDate fecha, int duracionDias, int precioDiario, boolean arriendoTerminado) {
        this.numero = numero;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.duracionDias = duracionDias;
        this.precioDiario = precioDiario;
        this.arriendoTerminado = arriendoTerminado;
        this.monto = duracionDias * precioDiario;
    }    

    public int getNumero() {
        return this.numero;
    }
        
    public Cliente getCliente() {
        return this.cliente;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
    
    public int getDuracionDias() {
        return this.duracionDias;
    }
    
    public int getPrecioDiario() {
        return this.precioDiario;
    }

    public boolean getArriendoTerminado() {
        return this.arriendoTerminado;
    }
    
    public int getMonto() {
        return this.monto;
    }

    public void setArriendoTerminado(boolean nuevoarriendoTerminado) {
        this.arriendoTerminado = nuevoarriendoTerminado;
    }

    public void mostrarInformacion() {
        System.out.println(
            "Numero: " + this.numero + "\n"
            + "    " + "Rut del cliente: " + this.cliente.getRut() + "\n"
            + "    " + "Patente del vehículo: " + this.vehiculo.getPatente() + "\n"
            + "    " + "Fecha: " + this.fecha + "\n"
            + "    " + "Días de arriendo: " + this.duracionDias + "\n"
            + "    " + "Precio por cada día: " + this.precioDiario + "\n"
            + "    " + "Vehículo devuelto: " + this.arriendoTerminado + "\n"
        );
    }

    public String ticket() {
        return
                "__________________________________________________________________\n"
            + "|            TICKET ARRIENDO DE VEHÍCULO\n"
            + "|        NÚMERO ARRIENDO: " + this.numero + "\n"
            + "|        VEHÍCULO       : " + this.vehiculo.getPatente() + " " + this.vehiculo.getMarca() + " " + this.vehiculo.getModelo() + "\n"
            + "|        PRECIO DIARIO  : $" + this.precioDiario + "\n"
            + "|FECHA         CLIENTE                     DIAS       A PAGAR" + "\n"
            + "|\n"
            + "|------------------------------------------------------------------\n"
            + "|" + this.fecha + "    " + this.cliente.getRut() + "/" + this.cliente.getNombre() + "   " + this.duracionDias + " días    $" + this.monto + "\n"
            + "|------------------------------------------------------------------\n"
            + "|\n"
            + "|\n"
            + "|                                  _______________\n"
            + "|                                   FIRMA CLIENTE\n"
            + "|__________________________________________________________________";
    }



}


    