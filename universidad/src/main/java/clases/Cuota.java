
package clases;

public final class Cuota {
	
    private String id;
    private int numCuota;
    private int valorCuota;
    private boolean pagada;

    public Cuota(int numCuota, int valorCuota, boolean pagada) {
        setId(numCuota + "");
        setNumCuota(numCuota);
        setValorCuota(valorCuota);
        setPagada(pagada);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public boolean pagarCuota() {
        return true;
    }

    @Override
    public String toString() {
        return this.numCuota + "-"
            + this.valorCuota + "-"
            + this.pagada;
    }
}
