package carStore;

public class Arriendo {
    private int numero;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private String fecha;
    private int duracionDias;
    private int monto;
    private boolean valido = true;


    public Arriendo(int numero, Vehiculo vehiculo, Cliente cliente, String fecha, int duracionDias, int precioPorDia) {
        this.numero = numero;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.duracionDias = duracionDias;
        this.monto = duracionDias * precioPorDia;
        
        if (vehiculo.getCondicion() != "D") {
        	System.out.println("El vehículo ingresado no está disponible.");
        	this.valido = false;
        } else if (!cliente.getVigente()) {
        	System.out.println("El cliente ingresado no está vigente.");
        	this.valido = false;
        }
        

    }    

	public int getNumero() {
    	return this.numero;
    }
	    
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public int getDuracionDias() {
		return this.duracionDias;
	}
	
	public int getMonto() {
		return this.monto;
	}

	public boolean getValido() {
		return this.valido;
	}

	
	
}
