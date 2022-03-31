package carStore;
import java.time.LocalDate;

public class Arriendo {
    private int numero;
	private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private int duracionDias;
	private int precioPorDia;
    private int monto;


    public Arriendo(int numero, Cliente cliente, Vehiculo vehiculo, LocalDate fecha, int duracionDias, int precioPorDia) {
        this.numero = numero;
		this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.duracionDias = duracionDias;
		this.precioPorDia = precioPorDia;
        this.monto = duracionDias * precioPorDia;
    }    

	public int getNumero() {
    	return this.numero;
    }
	    
	public Cliente getCliente() {
		return this.cliente;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public int getDuracionDias() {
		return this.duracionDias;
	}
	
	public int getPrecioPorDia() {
		return this.precioPorDia;
	}
	
	public int getMonto() {
		return this.monto;
	}


	public void mostrarInformacion() {
        System.out.println(
            "Numero: " + this.numero + "\n"
			+ "    " + "Rut del cliente: " + this.cliente.getRut() + "\n"
			+ "    " + "Patente del vehículo: " + this.vehiculo.getPatente() + "\n"
			+ "    " + "Fecha: " + this.fecha + "\n"
			+ "    " + "Días de arriendo: " + this.duracionDias + "\n"
			+ "    " + "Precio por cada día: " + this.precioPorDia + "\n"
        );
    }
}


