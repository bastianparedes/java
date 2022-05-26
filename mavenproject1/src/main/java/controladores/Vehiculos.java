
package controladores;

import clases.Vehiculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculos {
    
    public String fichero = "src/main/java/ficheros/vehiculos.txt";
    public ArrayList<Vehiculo> arrayList = new ArrayList<>();

    public Vehiculos() {
        this.cargarEnMemoria();
    }


    
    
    
    
    private void cargarEnMemoria() {
    	Scanner scanner = null;
    	File file = new File(this.fichero);
    	try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String rawData = scanner.nextLine();
                String[] arrayData = rawData.split(";");

                String patente = arrayData[0];
                char condicion = arrayData[1].charAt(0);

                Vehiculo vehiculo = new Vehiculo(patente, condicion);
                arrayList.add(vehiculo);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de vehiculos");
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

    public Object buscar(String id) {
    	return this.arrayList.stream().filter(object -> object.getId().equals(id)).findAny().orElse(null);
    }

}
