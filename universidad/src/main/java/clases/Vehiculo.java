
package clases;

public final class Vehiculo {

    private String id;
    private String patente;
    private char condicion;

    public Vehiculo(String patente, char condicion) {
        setId(patente);
        setPatente(patente);
        setCondicion(condicion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    @Override
    public String toString() {
        return this.patente + ";"
        + this.condicion;
    }
}
