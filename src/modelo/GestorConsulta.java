package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GestorConsulta {

    // metodo para generar día aleatorio del día -->
    public String generarFechaAleatoria(){
        // generamos fecha aleatoria válida a partir del día actual ->
        // para eso usamos la clase LocalDate de java.time ->
        java.time.LocalDate fechaActual = java.time.LocalDate.now();
        // generamos un número aleatorio de días a sumar entre 1 y 30 ->
        int diasASumar = (int)(Math.random() * 30) + 1; // Math.Random genera entre [0 y 1] y lo
        // multiplicamos por 30 para tener un rango de 0 a 29, y le sumamos 1 para que sea entre
        // 1 y 30!!
        java.time.LocalDate fechaAleatoria = fechaActual.plusDays(diasASumar);
        // devolvemos la fecha en formato String ->
        return fechaAleatoria.toString();
    }

    public boolean guardarConsulta(Consulta consulta){
        // metodo que guarda la consulta en el txt de consultas ->
        String linea = consulta.getVeterinario().getNombre() + "," + consulta.getVeterinario().getApellido() + "," + consulta.getMascota().getTipo() + "," +
                consulta.getMascota().getNombre() + "," + consulta.getFecha() + "," + consulta.getTratamiento().name();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/datos/consultas.txt", true))){
            writer.write(linea);
            writer.newLine(); // salto de línea para la próxima consulta!!
            return true; // si llegamos acá es porque se guardó correctamente!!
        } catch (java.io.IOException e){
            System.out.println("Error al escribir en el archivo de consultas: " + e.getMessage());
            return false; // hubo un error al guardar la consulta!!
        }
    }
}
