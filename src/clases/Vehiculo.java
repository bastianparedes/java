package clases;

public class Vehiculo {
	
	private String patente;
	private char condicion;
	
	public Vehiculo(String patente, char condicion) {
		setPatente(patente);
		setCondicion(condicion);
	}



	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public char getCondicion() {
		return condicion;
	}
	public void setCondicion(char condicion) {
		this.condicion = condicion;
	}



	public String toString() {
		return this.patente + ';'
			+ this.condicion;
	}
}
