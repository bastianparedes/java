package main;

import controladores.ArriendosConCuotas;
import controladores.Clientes;
import controladores.Vehiculos;
import interfaces.MainFrame;






public class Main {




        

	
    public static void main(String[] args) {
        Clientes clientes = new Clientes();
        Vehiculos vehiculos = new Vehiculos();
        ArriendosConCuotas arriendosConCuotas = new ArriendosConCuotas();
        
        
    	//vehiculos.removeIf(vehiculoEnMemoria -> vehiculoEnMemoria.getPatente().equals(patente));
        MainFrame frame = new MainFrame(clientes, vehiculos, arriendosConCuotas);
        frame.setVisible(true);
        System.out.println();
    }










}






