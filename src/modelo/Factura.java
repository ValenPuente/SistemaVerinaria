package modelo;

public class Factura {
    private static int idFactura=0;
    private Duenio duenio;
    private Tratamiento tratamiento;
    private double montoTotal;

    public Factura(Duenio duenio, Tratamiento tratamiento){
        idFactura++; // se le suma 1, es autoIncremental!!
        this.duenio = duenio;
        this.tratamiento = tratamiento;
        this.montoTotal = tratamiento.getCosto(); // coste del tratamiento asignado en la factura
    }

}
