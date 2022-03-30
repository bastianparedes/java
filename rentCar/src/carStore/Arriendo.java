package carStore;

public class Arriendo {
    private int numero;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private String fecha;
    private int duracionDias;
	private int precioPorDia;
    private int monto;


    public Arriendo(int numero, Vehiculo vehiculo, Cliente cliente, String fecha, int duracionDias, int precioPorDia) {
        this.numero = numero;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fecha = fecha;
        this.duracionDias = duracionDias;
		this.precioPorDia = precioPorDia;
        this.monto = duracionDias * precioPorDia;
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


	public void mostrarInformacion() {
        System.out.println(
            "Numero: " + this.numero + "\n"
			+ "    " + "Patente del vehículo: " + this.vehiculo.getPatente() + "\n"
			+ "    " + "Rut del cliente: " + this.cliente.getRut() + "\n"
			+ "    " + "Fecha: " + this.fecha + "\n"
			+ "    " + "Días de arriendo: " + this.duracionDias + "\n"
			+ "    " + "Precio por cada día: " + this.precioPorDia + "\n"
        );
    }


	
	public boolean devolver(Vehiculo vehiculoDevuelto, String fechaDevolucion) {
		this.vehiculo.setCondicion("D");
		return true;
	}
	
}


