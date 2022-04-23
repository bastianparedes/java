package clases;

public class Docente extends Usuario{

	private String grado;

	public Docente(String run, String nombreCompleto, String genero, String prestamo, String grado) {
		super(run, nombreCompleto, genero, prestamo);
		this.setGrado(grado);
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String rawData() {
		return super.rawData() + ";docente;" + this.grado;
	}
	
	public String orderedData() {
		return ""
				+ super.orderedData() + "\n"
				+ "Tipo: docente" + "\n"
				+ "Grado: " + this.grado;
	}
}
