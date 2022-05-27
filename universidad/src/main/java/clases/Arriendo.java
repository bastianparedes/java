
package clases;

import java.util.ArrayList;


public final class Arriendo {

    private String id;
    private int numArriendo;
    private String fecArr;
    private int diasArriendo;
    Cliente cliente;
    Vehiculo vehiculo;
    private int cantCuotas = 0;
    private ArrayList<Cuota> cuotas = new ArrayList<>();

    public Arriendo(int numArriendo, String fecArr, int diasArriendo, int cantCuotas) {
        setId(numArriendo + "");
        setNumArriendo(numArriendo);
        setFecArr(fecArr);
        setDiasArriendo(diasArriendo);
        setCantCuotas(cantCuotas);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    @Override
    public String toString() {
        String string = this.numArriendo + ";"
            + this.fecArr + ";"
            + this.diasArriendo + ";"
            + this.cantCuotas + ";"
            + this.cliente.getCedula() + ";"
            + this.vehiculo.getPatente();
        for (Cuota cuota: cuotas) {
            string += ';' + cuota.toString();
        }
        return string;
        
        
        
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
        if (evaluarArriendo()) {
            getVehiculo().setCondicion('A');
            setCuotas(generarCuotas(precioDia));
            return true;	
        }
        return false;
    }

    public ArrayList<Cuota> generarCuotas(int precioDia) {
        int valorCuota = obtenerMontoAPagar(precioDia) / this.cantCuotas;
        for (int numCuota=1 ; numCuota <= this.cantCuotas ; numCuota++) {
            cuotas.add(new Cuota(numCuota, valorCuota, false));
        }
        return cuotas; 
    }

    public boolean pagarCuota(int numCuota) {
        Cuota cuota = cuotas.stream().filter(cuotaEnLista -> cuotaEnLista.getNumCuota() == numCuota).findAny().orElse(null);
        if (cuota != null) {
            cuota.setPagada(true);
            return true;
        }
        return false;
    }

    public void addCuota(Cuota cuota) {
        this.cuotas.add(cuota);
    }
    
}