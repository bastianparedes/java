
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import carStore.Cliente;
import carStore.Vehiculo;
import carStore.Arriendo;


public class Main {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        ArrayList<Arriendo> arriendos = new ArrayList<Arriendo>();

        // GUARDA EN MEMORIA LOS CLIENTES
        for (String rawCliente: leerArchivo("clientes.txt")) {
            String[] arrayCliente = rawCliente.split(";");

            String rut = arrayCliente[0];
            String nombre = arrayCliente[1];
            boolean vigente = Boolean.parseBoolean(arrayCliente[2]);

            Cliente cliente = new Cliente(rut, nombre, vigente);
            clientes.add(cliente);
        }


        // GUARDA EN MEMORIA LOS VEHÍCULOS
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


        // GUARDA EN MEMORIA LOS ARRIENDOS
        for (String rawArriendo: leerArchivo("arriendos.txt")) {
            String[] arrayArriendo = rawArriendo.split(";");

            int numero = Integer.parseInt(arrayArriendo[0]);
            String rutCliente = arrayArriendo[1];
            String patenteVehiculo = arrayArriendo[2];
            LocalDate fecha = LocalDate.parse(arrayArriendo[3]);
            int duracionDias = Integer.parseInt(arrayArriendo[4]);
            int precioDiario = Integer.parseInt(arrayArriendo[5]);
            boolean arriendoTerminado = Boolean.parseBoolean(arrayArriendo[6]);

            Cliente cliente = clientes.stream().filter(clienteEnLista -> clienteEnLista.getRut().equals(rutCliente)).findAny().orElse(null);
            Vehiculo vehiculo = vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patenteVehiculo)).findAny().orElse(null);

            Arriendo arriendo = new Arriendo(numero, cliente, vehiculo, fecha, duracionDias, precioDiario, arriendoTerminado);
            arriendos.add(arriendo);
        }


        // COMIENZA EL MENU DE OPCIONES
        Scanner scanner = new Scanner(System.in);
        String opcionIngresada;
        while (true) {

            // MUESTRA EL MENÚ
            System.out.println(
                "\n\nIngresa uno de los números de la lista mostrada a continuación\n"
                + "1: Mostrar los clientes registrados.\n"
                + "2: Mostrar los vehículos registrados.\n"
                + "3: Mostrar los arriendos registrados.\n"
                + "4: Registrar nuevo cliente.\n"
                + "5: Registrar nuevo vehículo.\n"
                + "6: Registrar nuevo arriendo.\n"
                + "7: Realizar devolución de vehículo.\n"
                + "8: Deshabilitar cliente.\n"
                + "9: Cambiar la condición de un vehículo.\n"
                + "10: Cerrar programa.\n"
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
                System.out.println("\nIngresa el rut del nuevo cliente (Ej: 12345678-9):");
                String rut = scanner.nextLine();
                System.out.println("Ingresa el nombre del nuevo cliente:");
                String nombre = scanner.nextLine().toUpperCase();

                clientes.add(new Cliente(rut, nombre, true));
                
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\clientes.txt"));
                    for (Cliente cliente: clientes) {
                        bufferedWriter.write(cliente.getRut() + ';' + cliente.getNombre() + ';' + cliente.getVigente() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}

                System.out.println("\nCliente ingresado con éxito");






            } else if (opcionIngresada.equals("5")) {//REGISTRAR VEHICULO

                System.out.println("\nIngresa la patente del nuevo vehículo:");
                String patente = scanner.nextLine().toUpperCase();
                System.out.println("Ingresa la marca del nuevo vehículo:");
                String marca = scanner.nextLine().toUpperCase();
                System.out.println("Ingresa el modelo del nuevo vehículo:");
                String modelo = scanner.nextLine().toUpperCase();
                System.out.println("Ingresa el año del nuevo vehículo:");
                int year = scanner.nextInt();

                vehiculos.add(new Vehiculo(patente, marca, modelo, year, "D"));

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\vehiculos.txt"));
                    for (Vehiculo vehiculo: vehiculos) {
                        bufferedWriter.write(vehiculo.getPatente() + ';' + vehiculo.getMarca() + ';' + vehiculo.getModelo() + ';' + vehiculo.getYear() + ';' + vehiculo.getCondicion() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}

                System.out.println("\nVehículo ingresado con éxito");






            } else if (opcionIngresada.equals("6")) {//REGITRAR ARRIENDO

                System.out.println("");
                int numero = arriendos.size();

                Vehiculo vehiculo;
                while (true) {
                    System.out.println("Ingresa la patente del vehículo que se arrendará:");
                    String patente = scanner.nextLine().toUpperCase();
                    vehiculo = vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patente)).findAny().orElse(null);
                    if (vehiculo == null) {
                        System.out.println("La patente ingresada no pertenece a ningún vehículo registrado en nuestra base de datos.");
                    } else if (vehiculo.getCondicion().equals("A")) {
                        System.out.println("La patente ingresada corresponde a un vehículo que ya ha sido arrendado.");
                    } else if (vehiculo.getCondicion().equals("M")) {
                        System.out.println("La patente ingresada corresponde a un vehículo que está en mantención.");
                    } else {
                        break;
                    }
                }
                
                Cliente cliente;
                while (true) {
                    System.out.println("Ingresa el rut del cliente:");
                    String rut = scanner.nextLine();
                    cliente = clientes.stream().filter(clienteEnLista -> clienteEnLista.getRut().equals(rut)).findAny().orElse(null);
                    if (cliente == null) {
                        System.out.println("El rut ingresado no pertenece a ningun cliente registrado en nuestra base de datos.");
                    } else if (!cliente.getVigente()) {
                        System.out.println("El usuario ingresado no está vigente.");
                    } else {
                        break;
                    }
                }

                LocalDate fecha = LocalDate.now();
                System.out.println("Ingresa la cantidad de días que durará el arriendo:");
                int duracionDias = scanner.nextInt();
                System.out.println("Ingresa el precio de cada día de arriendo:");
                int precioDiario = scanner.nextInt();
                boolean arriendoTerminado = false;

                arriendos.add(new Arriendo(numero, cliente, vehiculo, fecha, duracionDias, precioDiario, arriendoTerminado));

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\arriendos.txt"));
                    for (Arriendo arriendo: arriendos) {
                        bufferedWriter.write(arriendo.getNumero() + ';' + arriendo.getCliente().getRut() + ';' + arriendo.getVehiculo().getPatente() + ';' + arriendo.getFecha() + ';' + arriendo.getDuracionDias() + ';' + arriendo.getPrecioDiario() + ';' + arriendo.getArriendoTerminado() + "\n");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {}




                // ===================================================== FALTA MODIFICAR CLIENTE
                // ===================================================== FALTA MODIFICAR VEHÍCULO
                System.out.println("\nArriendo ingresado con éxito");






            } else if (opcionIngresada.equals("7")) {//DEVOLVER AUTO AL RENT A CAR

                Arriendo arriendo;
                while (true) {
                    System.out.println("Ingresa el número del arriendo:");
                    int numero = scanner.nextInt();
                    arriendo = arriendos.stream().filter(arriendoEnLista -> arriendoEnLista.getNumero() == numero).findAny().orElse(null);
                    if (arriendo == null) {
                        System.out.println("El número de arriendo ingresado no existe en la base de datos, inténtalo de nuevo.");
                    } else if (arriendo.getArriendoTerminado()) {
                        System.out.println("El vehículo del arriendo ya ha sido devuelto.");
                    } else {
                        break;
                    }
                }

                arriendo.devolverAuto(vehiculos, arriendos);
                









            } else if (opcionIngresada.equals("8")) { //DESHABILITAR CLIENTE

                Cliente clienteModificado;
                while (true) { //primero busca al cliente si existe, luego verifica si no estaba vigente de antes y finalmente lo deshabilita
                    System.out.println("Ingresa el rut del cliente:");
                    String rut = scanner.nextLine();
                    clienteModificado = clientes.stream().filter(clienteEnLista -> clienteEnLista.getRut().equals(rut)).findAny().orElse(null);
                    if (clienteModificado == null) {
                        System.out.println("El rut ingresado no pertenece a ningun cliente registrado en nuestra base de datos.");
                    } else if (!clienteModificado.getVigente()) {
                        System.out.println("El usuario ingresado no se encontraba vigente.");
                        break;
                    } else { //modifica al cliente y los guarda todos

                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\clientes.txt"));
                            clienteModificado.setVigente(false);
                            for (Cliente cliente: clientes) {
                                bufferedWriter.write(cliente.getRut() + ';' + cliente.getNombre() + ';' + cliente.getVigente() + "\n");
                            }
                            bufferedWriter.close();
                        } catch (IOException e) {}
                        System.out.println("Cliente deshabilitado con éxito.");
                        break;

                    }
                }










            } else if (opcionIngresada.equals("9")) {//CAMBIAR CONDICION VEHICULO
                Vehiculo vehiculoModificado;
                while (true) {
                    System.out.println("Ingresa la patente del vehículo:");
                    String patente = scanner.nextLine().toUpperCase();
                    vehiculoModificado = vehiculos.stream().filter(vehiculoEnLista -> vehiculoEnLista.getPatente().equals(patente)).findAny().orElse(null);
                    if (vehiculoModificado == null) {
                        System.out.println("La patente ingresada no pertenece a ningún vehículo registrado en nuestra base de datos.");
                    } else if (vehiculoModificado.getCondicion().equals("A")) {
                        System.out.println("La patente ingresada pertenece a un vehículo que está siendo arrendado.");
                    } else {
                        String nuevaCondicion;
                        while (true) { //PIDE LA NUEVA CONDICIÓN
                            System.out.println("Ingresa la nueva condicion del vehículo (D o M):");
                            nuevaCondicion = scanner.nextLine().toUpperCase();
                            if (!nuevaCondicion.equals("D") && !nuevaCondicion.equals("M")) {
                                System.out.println("Esa no es una condición válida");
                            } else {
                                break;
                            }
                        }

                        vehiculoModificado.setCondicion(nuevaCondicion);
                        try { //GUARDA EN LA BD LOS VEHICULOS
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BD\\vehiculos.txt"));
                            for (Vehiculo vehiculo: vehiculos) {
                                bufferedWriter.write(vehiculo.getPatente() + ';' + vehiculo.getMarca() + ';' + vehiculo.getModelo() + ';' + vehiculo.getYear() + ';' + vehiculo.getCondicion() + "\n");
                            }
                            bufferedWriter.close();
                        } catch (IOException e) {}
                        break;
                    }
                }







            } else if (opcionIngresada.equals("10")) {//TERMINAR PROGRAMA
                scanner.close();
                break;
            }else {
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


