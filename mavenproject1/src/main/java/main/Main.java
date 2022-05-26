package main;

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
import clases.Controlador;
import controladores.ArriendosConCuotas;
import controladores.Clientes;
import controladores.Vehiculos;

import interfaces.MainFrame;
import java.util.List;




public class Main {


    
    public static Clientes clientes = new Clientes();
    public static Vehiculos vehiculos = new Vehiculos();
    public static ArriendosConCuotas arriendosConCuotas = new ArriendosConCuotas();
    
    

        

	
    public static void main(String[] args) {
        
    	//vehiculos.removeIf(vehiculoEnMemoria -> vehiculoEnMemoria.getPatente().equals(patente));
        //MainFrame frame = new MainFrame();
        //frame.setVisible(true);
        System.out.println();
    }











    public static void guardarInformacionEnFicheros() {
    	clientes.guardarEnFichero();
    	vehiculos.guardarEnFichero();
    	arriendosConCuotas.guardarEnFichero();
    }
}














