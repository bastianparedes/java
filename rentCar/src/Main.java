// 0;HDGZ41;10111648-8;30/04/2019;15000;45
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import carStore.Cliente;
import carStore.Vehiculo;
import carStore.Arriendo;


public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        ArrayList<Arriendo> arriendos = new ArrayList<Arriendo>();

        // GUARDA Y MUESTRA LOS CLIENTES
        for (String rawCliente: leerArchivo("clientes.txt")) {
            String[] arrayCliente = rawCliente.split(";");

            String rut = arrayCliente[0];
            String nombre = arrayCliente[1];
            boolean vigente = Boolean.parseBoolean(arrayCliente[2]);

            Cliente cliente = new Cliente(rut, nombre, vigente);
            clientes.add(cliente);
        }


        // GUARDA Y MUESTRA LOS VEHÍCULOS
        for (String rawVehiculo: leerArchivo("vehiculos.txt")) {
            String[] arrayVehiculo = rawVehiculo.split(";");

            String patente = arrayVehiculo[0];
            String marca = arrayVehiculo[1];
            String modelo = arrayVehiculo[2];
            int year = Integer.parseInt(arrayVehiculo[3]);
            String condicion = arrayVehiculo[4];

            Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, year, condicion);
            vehiculos.add(vehiculo);
        }


        // GUARDA Y MUESTRA LOS ARRIENDOS
        for (String rawArriendo: leerArchivo("arriendos.txt")) {
            String[] arrayArriendo = rawArriendo.split(";");

            int numero = Integer.parseInt(arrayArriendo[0]);
            String patenteVehiculo = arrayArriendo[1];
            String rutCliente = arrayArriendo[2];
            String fecha = arrayArriendo[3];
            int duracionDias = Integer.parseInt(arrayArriendo[4]);
            int precioPorDia = Integer.parseInt(arrayArriendo[5]);

            Vehiculo vehiculo = vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patenteVehiculo)).findAny().orElse(null);
            Cliente cliente = clientes.stream().filter(clienteEnLista -> clienteEnLista.getRut().equals(rutCliente)).findAny().orElse(null);

            Arriendo arriendo = new Arriendo(numero, vehiculo, cliente, fecha, duracionDias, precioPorDia);
            arriendos.add(arriendo);
        }


        // COMIENZA EL MENU DE OPCIONES
        Scanner scanner = new Scanner(System.in);
        String opcionIngresada;
        while (true) {

            // MUESTRA EL MENÚ
            System.out.println(
                "Ingresa uno de los números de la lista mostrada a continuación\n"
                + "1: Mostrar los clientes registrados.\n"
                + "2: Mostrar los vehículos registrados.\n"
                + "3: Mostrar los arriendos registrados.\n"
                + "4: Registrar nuevo vehículo.\n"
                + "5: Registrar nuevo cliente.\n"
                + "6: Registrar nuevo arriendo.\n"
                + "7: Realizar devolución de vehículo.\n"
                + "8: Deshabilitar cliente.\n"
                + "9: Cerrar programa.\n"
                + "¿Qué deseas hacer?"
            );

            // DETECTA LA OPCIÓN ELEGIDA
            opcionIngresada = scanner.nextLine();

            if (opcionIngresada.equals("1")) {//MOSTRAR CLIENTES
                System.out.println("\n\n\n" + "==========CLIENTES REGISTRADOS==========");
                for (Cliente cliente: clientes) {
                    cliente.mostrarInformacion();
                }





            } else if (opcionIngresada.equals("2")) {//MOSTRAR VEHICULOS
                System.out.println("\n\n\n" + "==========VEHÍCULOS REGISTRADOS==========");
                for (Vehiculo vehiculo: vehiculos) {
                    vehiculo.mostrarInformacion();
                }




                
            } else if (opcionIngresada.equals("3")) {//MOSTRAR ARRIENDOS
                System.out.println("\n\n\n" + "==========ARRIENDOS REGISTRADOS==========");
                for (Arriendo arriendo: arriendos) {
                    arriendo.mostrarInformacion();
                }





            } else if (opcionIngresada.equals("4")) {//REGISTRAR CLIENTE

                // Cliente 

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\clientes.txt"));
                    for (Cliente cliente: clientes) {
                        bufferedWriter.write(cliente.getRut() + ";" + cliente.getNombre() + ";" + cliente.getVigente() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}






            } else if (opcionIngresada.equals("5")) {//REGISTRAR VEHICULO
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\vehiculos.txt"));
                    for (Vehiculo vehiculo: vehiculos) {
                        bufferedWriter.write(vehiculo.getPatente() + ";" + vehiculo.getMarca() + ";" + vehiculo.getModelo() + ";" + vehiculo.getYear() + ";" + vehiculo.getCondicion() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}






            } else if (opcionIngresada.equals("6")) {//REGITRAR ARRIENDO
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\arriendos.txt"));
                    for (Arriendo arriendo: arriendos) {
                        bufferedWriter.write(arriendo.getNumero() + ";" + arriendo.getVehiculo().getPatente() + ";" + arriendo.getCliente().getRut() + ";" + arriendo.getFecha() + ";" + arriendo.getDuracionDias() + ";" + arriendo.getPrecioPorDia() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}





            } else if (opcionIngresada.equals("7")) {//DEVOLVER AUTO AL RENT A CAR









            } else if (opcionIngresada.equals("8")) {//DESHABILITAR CLIENTE







            } else if (opcionIngresada.equals("9")) {
                scanner.close();    
                break;








            } else {
                System.out.println("\n\n\nIngresaste un valor inválido. Inténtelo denuevo.\n");
            }

        }
        

        System.out.println("Programa finalizado!!!");






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


