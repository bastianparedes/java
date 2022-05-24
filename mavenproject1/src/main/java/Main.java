
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;

import clases.Cliente;
import clases.Vehiculo;
import clases.Cuota;
import clases.Arriendo;
import clases.ArriendoConCuotas;

import interfaces.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static ArrayList<Arriendo> arriendos = new ArrayList<Arriendo>();
    public static ArrayList<ArriendoConCuotas> arriendosConCuotas = new ArrayList<ArriendoConCuotas>();
    public static String ubicacionFicheros = "src/main/java/ficheros/";

        

	
    public static void main(String[] args) {
    	cargarClientesEnMemoria();
    	cargarVehiculosEnMemoria();
    	cargarArriendosEnMemoria();
    	cargarArriendosConCuotasEnMemoria();
    	//vehiculos.removeIf(vehiculoEnMemoria -> vehiculoEnMemoria.getPatente().equals(patente));
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        
    }










    public static boolean existeCliente(String cedula) {
    	return null != clientes.stream().filter(clienteEnLista -> clienteEnLista.getCedula().equals(cedula)).findAny().orElse(null);
    }
    
    public static boolean existeVehiculo(String patente) {
    	return null != vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patente)).findAny().orElse(null);
    }
   
    public static boolean existeArriendo(int numArriendo) {
    	return null != arriendos.stream().filter(arriendoEnLista -> arriendoEnLista.getNumArriendo() == numArriendo).findAny().orElse(null);
    }

    public static boolean existeArriendoConCuotas(int numArriendo) {
    	return null != arriendosConCuotas.stream().filter(arriendoConCuotasEnLista -> arriendoConCuotasEnLista.getNumArriendo() == numArriendo).findAny().orElse(null);
    }



    public static Cliente buscarCliente(String cedula) {
    	return clientes.stream().filter(clienteEnLista -> clienteEnLista.getCedula().equals(cedula)).findAny().orElse(null);
    }

    public static Vehiculo buscarVehiculo(String patente) {
    	return vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patente)).findAny().orElse(null);  
    }

    public static Arriendo buscarArriendo(int numArriendo) {
    	return  arriendos.stream().filter(arriendoEnLista -> arriendoEnLista.getNumArriendo() == numArriendo).findAny().orElse(null);  
    }

    public static ArriendoConCuotas buscarArriendoConCuotas(int numArriendo) {
    	return arriendosConCuotas.stream().filter(arriendoConCuotasEnLista -> arriendoConCuotasEnLista.getNumArriendo() == numArriendo).findAny().orElse(null);
    }





    
    
    
    

    
    
    public static void cargarClientesEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(ubicacionFicheros + "clientes.txt");
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
    			
                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                String cedula = arrayData[0];
                String nombre = arrayData[1];
                boolean vigente = Boolean.parseBoolean(arrayData[2]);

                Cliente cliente = new Cliente(cedula, nombre, vigente);
                clientes.add(cliente);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de clientes");
    	} finally {}
    }

    public static void cargarVehiculosEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(ubicacionFicheros + "vehiculos.txt");
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                String patente = arrayData[0];
                char condicion = arrayData[1].charAt(0);

                Vehiculo vehiculo = new Vehiculo(patente, condicion);
                vehiculos.add(vehiculo);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de vehiculos");
    	} finally {}
    }

    public static void cargarArriendosEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(ubicacionFicheros + "arriendos.txt");
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                int numArriendo = Integer.parseInt(arrayData[0]);
                String fecArr = arrayData[1];
                int diasArriendo = Integer.parseInt(arrayData[2]);

                Arriendo arriendo = new Arriendo(numArriendo, fecArr, diasArriendo);
                arriendos.add(arriendo);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de arriendos");
    	} finally {}
    }

    public static void cargarArriendosConCuotasEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(ubicacionFicheros + "arriendosConCuotas.txt");
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
    			
                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                int numArriendo = Integer.parseInt(arrayData[0]);
                String fecArr = arrayData[1];
                int diasArriendo = Integer.parseInt(arrayData[2]);
                int cantCuotas = Integer.parseInt(arrayData[3]);

                ArriendoConCuotas arriendoConCuotas = new ArriendoConCuotas(numArriendo, fecArr, diasArriendo, cantCuotas);
                for (int i=4 ; i < arrayData.length ; i++) {
                    String cuotaRawData = scanner.nextLine();
                    String[] cuotaArrayData = rawData.split("-");

                    int numCuota = Integer.parseInt(cuotaArrayData[0]);
                    int valorCuota = Integer.parseInt(cuotaArrayData[1]);
                    boolean pagada = Boolean.parseBoolean(arrayData[2]);

                    Cuota cuota = new Cuota(numCuota, valorCuota, pagada);
                    arriendoConCuotas.addCuota(cuota);
                }


                arriendosConCuotas.add(arriendoConCuotas);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de arriendos con cuotas");
    	} finally {}
    }








    public static void guardarClientesEnFichero() {
    	try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ubicacionFicheros + "clientes.txt"));
            for (Cliente cliente: clientes) {
            	bufferedWriter.write(cliente.toString() + "\n");
            }
            bufferedWriter.close();
    	} catch (IOException e) {}
    }

    public static void guardarVehiculosEnFichero() {
    	try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ubicacionFicheros + "vehiculos.txt"));
            for (Vehiculo vehiculo: vehiculos) {
                bufferedWriter.write(vehiculo.toString() + "\n");
            }
            bufferedWriter.close();
    	} catch (IOException e) {}
    }

    public static void guardarArriendosEnFichero() {
    	try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ubicacionFicheros + "arriendos.txt"));
            for (Arriendo arriendo: arriendos) {
                bufferedWriter.write(arriendo.toString() + "\n");
            }
            bufferedWriter.close();
    	} catch (IOException e) {}
    }

    public static void guardarArriendosConCuotasEnFichero() {
    	try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ubicacionFicheros + "arriendosConCuotas.txt"));
            for (ArriendoConCuotas arriendoConCuotas: arriendosConCuotas) {
                bufferedWriter.write(arriendoConCuotas.toString() + "\n");
            }
            bufferedWriter.close();
    	} catch (IOException e) {}
    }


    public static void guardarInformacionEnFicheros() {
    	guardarClientesEnFichero();
    	guardarVehiculosEnFichero();
    	guardarArriendosEnFichero();
    	guardarArriendosConCuotasEnFichero();
    }

}

