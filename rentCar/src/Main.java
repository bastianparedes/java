
import carStore.Arriendo;
import carStore.Cliente;
import carStore.Vehiculo;

public class Main {

	public static void main(String[] args) {
		
        Cliente cliente = new Cliente("19111648-8", "Metrik el macho");
        Vehiculo vehiculo = new Vehiculo(2015);
        
        Arriendo arriendo = new Arriendo(1, vehiculo, cliente, "01/01/1990", 5, 10000);

        
        
        
        
        
        
        
        
        
        
        System.out.println("Programa finalizado.");
    }

}
