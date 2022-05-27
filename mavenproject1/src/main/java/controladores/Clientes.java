
package controladores;

import clases.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
    
    
    public String fichero = "src/main/java/ficheros/clientes.txt";
    public ArrayList<Cliente> arrayList = new ArrayList<>();

    public Clientes() {
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

                String cedula = arrayData[0];
                String nombre = arrayData[1];
                boolean vigente = Boolean.parseBoolean(arrayData[2]);

                Cliente cliente = new Cliente(cedula, nombre, vigente);
                arrayList.add(cliente);
            }
    	} catch (Exception ex) {
            System.out.println("Error al leer el archivo de clientes");
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

    public Cliente buscar(String id) {
    	return this.arrayList.stream().filter(object -> object.getId().equals(id)).findAny().orElse(null);
    }

}
