
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import carStore.Cliente;
import carStore.Vehiculo;
import carStore.Arriendo;


public class Main {

    

    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        ArrayList<Arriendo> listaArriendos = new ArrayList<Arriendo>();

        // GUARDA Y MUESTRA LOS CLIENTES
        System.out.println("\n\n\n" + "==========CLIENTES REGISTRADOS==========");
        for (String rawCliente: leerArchivo("clientes.txt")) {
            String[] arrayCliente = rawCliente.split(";");

            String rut = arrayCliente[0];
            String nombre = arrayCliente[1];
            boolean vigente = Boolean.parseBoolean(arrayCliente[2]);

            Cliente cliente = new Cliente(rut, nombre, vigente);
            listaClientes.add(cliente);

            cliente.mostrarInformacion();
        }


        // GUARDA Y MUESTRA LOS VEHÍCULOS
        System.out.println("\n\n\n" + "==========VEHÍCULOS REGISTRADOS==========");
        for (String rawVehiculo: leerArchivo("vehiculos.txt")) {
            String[] arrayVehiculo = rawVehiculo.split(";");

            String patente = arrayVehiculo[0];
            String marca = arrayVehiculo[1];
            String modelo = arrayVehiculo[2];
            int year = Integer.parseInt(arrayVehiculo[3]);
            String condicion = arrayVehiculo[4];

            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, year, condicion);
            listaVehiculos.add(vehiculo);

            vehiculo.mostrarInformacion();
        }


        // GUARDA Y MUESTRA LOS ARRIENDOS
        System.out.println("\n\n\n" + "==========ARRIENDOS REGISTRADOS==========");
        for (String rawArriendo: leerArchivo("Arriendos.txt")) {
            String[] arrayArriendo = rawArriendo.split(";");

            int numero = Integer.parseInt(arrayArriendo[0]);
            String patenteVehiculo = arrayArriendo[1];
            String rutCliente = arrayArriendo[2];
            String fecha = arrayArriendo[3];
            int duracionDias = Integer.parseInt(arrayArriendo[4]);
            int precioPorDia = Integer.parseInt(arrayArriendo[5]);

            Vehiculo vehiculo = listaVehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patenteVehiculo)).findAny().orElse(null);
            Cliente cliente = listaClientes.stream().filter(clienteEnLista -> clienteEnLista.getRut().equals(rutCliente)).findAny().orElse(null);

            vehiculo.mostrarInformacion();

            Arriendo arriendo = new Arriendo(numero, vehiculo, cliente, fecha, duracionDias, precioPorDia);
            listaArriendos.add(arriendo);

            arriendo.mostrarInformacion();
        }

    }





    public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> interiorArchivo = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(
                new File("BD\\" + nombreArchivo)
            );
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                interiorArchivo.add(linea);
        }
            scanner.close();
        } catch (FileNotFoundException e) {

        }
        return interiorArchivo;
    }


}


