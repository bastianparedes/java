package clases;

public class Cuota {
	
	private int numCuota;
	private int valorCuota;
	private boolean pagada;
	
	public Cuota(int numCuota, int valorCuota, boolean pagada) {
		setNumCuota(numCuota);
		setValorCuota(valorCuota);
		setPagada(pagada);
	}



	public int getNumCuota() {
		return numCuota;
	}

	public void setNumCuota(int numCuota) {
		this.numCuota = numCuota;
	}

	public int getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(int valorCuota) {
		this.valorCuota = valorCuota;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	
	public boolean pagarCuota() {
		
		return true;
	}
	
	public String toString() {
		return this.numCuota + "-"
			+ this.valorCuota + '-'
			+ this.pagada;
	}
}
