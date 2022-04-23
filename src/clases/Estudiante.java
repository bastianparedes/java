package clases;

public class Estudiante extends Usuario{

	private String carrera;

	public Estudiante(String run, String nombreCompleto, String genero, String prestamo, String carrera) {
		super(run, nombreCompleto, genero, prestamo);
		this.setCarrera(carrera);
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String rawData() {
		return super.rawData() + ";estudiante;" + this.carrera;
	}
	
	public String orderedData() {
		return ""
				+ super.orderedData() + "\n"
				+ "Tipo: estudiante" + "\n"
				+ "Carrera: " + this.carrera;
	}
}
