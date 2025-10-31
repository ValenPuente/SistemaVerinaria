package modelo;

public enum Tratamiento { // guardamos los tratamientos como constantes dentro del enum y con atributo su costo
    VACUNACION(50.0),
    DESPARASITACION(30.0),
    LIMPIEZA_DENTAL(100.0),
    CIRUGIA_MENOR(200.0),
    CIRUGIA_MAYOR(500.0),
    CONSULTA_GENERAL(40.0),
    URGENCIA(150.0);

    private final double costo; // atributo que tiene cada constante

    Tratamiento(double costo) { // constructor
        this.costo = costo;
    }

    public double getCosto() { // metodo para acceder a los costos
        return costo;
    }
    // setter no porque es un atributo final!!! No deben cambiar los atributos de un enum!!!
}
