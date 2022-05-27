
package controladores;

import clases.ArriendoConCuotas;
import clases.Cuota;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArriendosConCuotas {
    
    public String fichero = "src/main/java/ficheros/arriendosConCuotas.txt";
    public ArrayList<ArriendoConCuotas> arrayList = new ArrayList<>();

    public ArriendosConCuotas() {
        this.cargarEnMemoria();
    }


    
    
    
    
    private void cargarEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(this.fichero);
        Clientes clientes = new Clientes();
        Vehiculos vehiculos = new Vehiculos();
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
    			
                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                int numArriendo = Integer.parseInt(arrayData[0]);
                String fecArr = arrayData[1];
                int diasArriendo = Integer.parseInt(arrayData[2]);
                int cantCuotas = Integer.parseInt(arrayData[3]);
                String cedula = arrayData[4];
                String patente = arrayData[5];

                ArriendoConCuotas arriendoConCuotas = new ArriendoConCuotas(numArriendo, fecArr, diasArriendo, cantCuotas);
                arriendoConCuotas.setCliente(clientes.buscar(cedula));
                arriendoConCuotas.setVehiculo(vehiculos.buscar(patente));
                
                
                for (int i=6 ; i < arrayData.length ; i++) {
                    String cuotaRawData = arrayData[i];
                    String[] cuotaArrayData = cuotaRawData.split("-");

                    int numCuota = Integer.parseInt(cuotaArrayData[0]);
                    int valorCuota = Integer.parseInt(cuotaArrayData[1]);
                    boolean pagada = Boolean.parseBoolean(arrayData[2]);

                    Cuota cuota = new Cuota(numCuota, valorCuota, pagada);
                    arriendoConCuotas.addCuota(cuota);
                }


                arrayList.add(arriendoConCuotas);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de arriendos con cuotas");
    	} finally {}
    }
    
    
    
    public void guardarEnFichero() {
    	try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.fichero));
            for (Object object: this.arrayList) {
                bufferedWriter.write(object.toString() + "\n");
            }
            bufferedWriter.close();
    	} catch (IOException e) {}
    }
    
    
    public boolean existe(String id) {
    	return null != this.arrayList.stream().filter(object -> object.getId().equals(id)).findAny().orElse(null);
    }

    public ArriendoConCuotas buscar(String id) {
    	return this.arrayList.stream().filter(object -> object.getId().equals(id)).findAny().orElse(null);
    }

}
