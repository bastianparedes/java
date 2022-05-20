
package clases;


public class Arriendo {

	private int numArriendo;
	private String fecArr;
	private int diasArriendo;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	public Arriendo(int numArriendo, String fecArr, int diasArriendo) {
            setNumArriendo(numArriendo);
            setFecArr(fecArr);
            setDiasArriendo(diasArriendo);
	}



	public int getNumArriendo() {
            return numArriendo;
	}

	public void setNumArriendo(int numArriendo) {
            this.numArriendo = numArriendo;
	}

	public String getFecArr() {
            return fecArr;
	}

	public void setFecArr(String fecArr) {
            this.fecArr = fecArr;
	}

	public int getDiasArriendo() {
            return diasArriendo;
	}

	public void setDiasArriendo(int diasArriendo) {
            this.diasArriendo = diasArriendo;
	}

	public Cliente getCliente() {
            return cliente;
        }

	public void setCliente(Cliente cliente) {
            this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
            return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
	}


	public int obtenerMontoAPagar(int precioDia) {
            return precioDia * getDiasArriendo();
	}
	
	public boolean evaluarArriendo() {
            return cliente.getVigente() && (vehiculo.getCondicion() == 'D');
	}

	
	public String toString() {
            return this.numArriendo + ';'
                + this.fecArr + ';'
                + this.diasArriendo;
	}
	
}