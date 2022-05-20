package clases;

public class Cliente {

	private String cedula;
	private String nombre;
	private boolean vigente;
	
	public Cliente(String cedula, String nombre, boolean vigente) {
		setCedula(cedula);
		setNombre(nombre);
		setVigente(vigente);
	}



	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}



	public String toString() {
		return this.cedula + ';'
			+ this.nombre + ';'
			+ this.vigente;
	}
}
