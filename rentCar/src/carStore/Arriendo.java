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

    public void mostrarTicket() {
        System.out.println(
            "");
    }


    public void devolverAuto(ArrayList<Vehiculo> vehiculos, ArrayList<Arriendo> arriendos) {
        //GUARDA LEL VEHÍCULO CON CONDICIÓN D
        this.vehiculo.setCondicion("D");//el cambio de esta linea también aplica a la base de datos cargada durante la ram
        try { //GUARDA EN LA BD LOS VEHICULOS
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\vehiculos.txt"));
            for (Vehiculo vehiculo: vehiculos) {
                bufferedWriter.write(vehiculo.getPatente() + ';' + vehiculo.getMarca() + ';' + vehiculo.getModelo() + ';' + vehiculo.getYear() + ';' + vehiculo.getCondicion() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {}

        this.setArriendoTerminado(true);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\arriendos.txt"));
            for (Arriendo arriendo: arriendos) {
                bufferedWriter.write(arriendo.getNumero() + ';' + arriendo.getCliente().getRut() + ';' + arriendo.getVehiculo().getPatente() + ';' + arriendo.getFecha() + ';' + arriendo.getDuracionDias() + ';' + arriendo.getPrecioDiario() + ';' + arriendo.getArriendoTerminado() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {}

    }


}


    