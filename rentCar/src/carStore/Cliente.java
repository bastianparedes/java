package carStore;

public class Cliente {

    private String rut;
    private String nombre;
    private boolean vigente = true;

    public Cliente(String rut, String nombre, boolean vigente) {
        this.rut = rut;
        this.nombre = nombre;
        this.vigente = vigente;
    }

    
    
    
    
    
    public String getRut() {
        return this.rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean getVigente() {
        return this.vigente;
    }

    public void deshabilitar() {
    	this.vigente = false;
    }
    
    public void mostrarInformacion() {

        System.out.println(
            "Rut: " + this.rut + "\n"
             + "    " + "Nombre: " + this.nombre + "\n"
             + "    " + "Vigente: " + this.vigente + "\n"
        );
    }
}
