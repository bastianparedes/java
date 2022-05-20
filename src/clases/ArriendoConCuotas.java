package clases;

import java.util.ArrayList;

public class ArriendoConCuotas extends Arriendo {
	
	private int cantCuotas;
	private ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
	
	public ArriendoConCuotas(int numArriendo, String fecArr, int diasArriendo, int cantCuotas) {
		super(numArriendo, fecArr, diasArriendo);
		setCantCuotas(cantCuotas);
	}



	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(ArrayList<Cuota> cuotas) {
		this.cuotas = cuotas;
	}



	public boolean ingresarArriendoConCuota(int precioDia) {
		if (super.evaluarArriendo()) {
			super.getVehiculo().setCondicion('A');
			setCuotas(generarCuotas(precioDia));
			return true;	
		}
		return false;
	}
	
	public ArrayList<Cuota> generarCuotas(int precioDia) {
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		int valorCuota = super.obtenerMontoAPagar(precioDia) / this.cantCuotas;
		for (int numCuota=1 ; numCuota < this.cantCuotas ; numCuota++) {
			cuotas.add(new Cuota(numCuota, valorCuota, false));
		}
		
		return cuotas; 
	}

	public boolean pagarCuota(int numCuota) {
		Cuota cuota = cuotas.stream().filter(cuotaEnLista -> cuotaEnLista.getNumCuota() == numCuota).findAny().orElse(null);
		if (cuota != null) {
			cuota.pagarCuota();
			return true;
		}
		return false;
	}

	public void addCuota(Cuota cuota) {
		this.cuotas.add(cuota);
	}

	public String toString() {
		String string = super.toString() + ';'
			+ this.cantCuotas;
		for (Cuota cuota: cuotas) {
			string += ';' + cuota.toString();
		}
		return string;
	}
	
}
