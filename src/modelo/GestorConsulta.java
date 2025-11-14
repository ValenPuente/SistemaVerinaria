package modelo;

import java.io.*;
import java.util.regex.Pattern;

public class GestorConsulta {

    // atributos para validar el formato de los campos en la vista consulta que usará el metodo validar!-->
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"); // verifica
    // que tenga un @, y que termina en .!
    private static final Pattern PHONE = Pattern.compile("^[0-9+()\\-\\s]{6,20}$"); // verifica que
    // tenga entre 6 y 20 caracteres
    private static final Pattern DIGITS = Pattern.compile("^\\d+$"); // solo dígitos del 0 al 9
    private boolean blank(String s){ return s == null || s.trim().isEmpty(); } // metodo para
    // verificar si un String que se recupera de los datos que pone el usuario está vacío o es nulo!!


    // metodo para validar los datos ingresados en la vista consulta -->
    public String validar(
            String nombreDuenio, String apellidoDuenio,
            String telefono, String email,
            String tipoMascota, String nombreMascota, String edadMascota,
            String condicion, Tratamiento tratamiento
    ) {
        if (blank(nombreDuenio)) return "ERROR: El nombre del dueño es obligatorio.";
        if (blank(apellidoDuenio)) return "ERROR: El apellido del dueño es obligatorio.";
        if (blank(telefono)) return "ERROR: El teléfono es obligatorio.";
        if (!PHONE.matcher(telefono).matches()) return "ERROR: El teléfono tiene un formato inválido.";
        if (blank(email)) return "ERROR: El email es obligatorio.";
        if (!EMAIL.matcher(email).matches()) return "ERROR: El email tiene un formato inválido.";
        if (blank(tipoMascota)) return "ERROR: El tipo de mascota es obligatorio.";
        if (blank(nombreMascota)) return "ERROR: El nombre de la mascota es obligatorio.";
        if (blank(edadMascota)) return "ERROR: La edad de la mascota es obligatoria.";
        if (!DIGITS.matcher(edadMascota).matches()) return "ERROR: La edad debe ser un número entero.";
        try {
            if (Integer.parseInt(edadMascota) < 0) return "ERROR: La edad no puede ser negativa.";
        } catch (NumberFormatException e) { return "ERROR: La edad tiene un formato inválido."; }
        if (blank(condicion)) return "ERROR: La condición/problema es obligatoria.";
        if (tratamiento == null) return "ERROR: Debe seleccionar un tratamiento.";
        return null;
    }

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
        String linea = consulta.getVeterinario().getNombre() +
                "," + consulta.getVeterinario().getApellido() +
                "," + consulta.getMascota().getDuenio().getNombre() + ","
                + consulta.getMascota().getDuenio().getApellido() + ","
                + consulta.getMascota().getDuenio().getNumTelefono() + ","
                + consulta.getMascota().getDuenio().getEmail() + ","
                + consulta.getMascota().getTipo() + ","
                + consulta.getMascota().getNombre() + ","
                + consulta.getFecha() + ","
                + consulta.getTratamiento().name();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/datos/consultas.txt", true))){
            writer.write(linea);
            writer.newLine(); // salto de línea para la próxima consulta!!
            return true; // si llegamos acá es porque se guardó correctamente!!
        } catch (IOException e){
            System.out.println("Error al escribir en el archivo de consultas: " + e.getMessage());
            return false; // hubo un error al guardar la consulta!!
        }
    }

    public Tratamiento obtenerUltimoTratamiento() {
        // metodo que obtiene el último tratamiento registrado en el txt de consultas ->
        String ultimaLinea = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/datos/consultas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                ultimaLinea = linea; // al finalizar el while, ultimaLinea tendrá la última línea del archivo!!
            }
            if (ultimaLinea != null) {
                String[] partes = ultimaLinea.split(","); // devuelve una lista donde cada índice es un
                // campo/atributo del registro de consulta!!
                String tratamientoStr = partes[9]; // el tratamiento está en la posición 9 del array!!!
                return Tratamiento.valueOf(tratamientoStr); // convertimos el String a enum Tratamiento!!
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de consultas: " + e.getMessage());
        }
        return null; // si no hay consultas o hubo un error, devolvemos null!!
    }

    public Duenio obtenerUltimoDuenio() {
        // metodo que obtiene el último dueño registrado en el txt de consultas ->
        String ultimaLinea = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/datos/consultas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                ultimaLinea = linea; // al finalizar el while, ultimaLinea tendrá la última línea del archivo!!
            }
            if (ultimaLinea != null) {
                String[] partes = ultimaLinea.split(","); // devuelve una lista donde cada índice es un
                // campo/atributo del registro de consulta!!
                String nombreDuenio = partes[2];
                String apellidoDuenio = partes[3];
                String numTelefono = partes[4];
                String email = partes[5];
                return new Duenio(nombreDuenio, apellidoDuenio, numTelefono, email); // retornamos el duenio
                // creado!!
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de consultas: " + e.getMessage());
        }
        return null; // si no hay consultas o hubo un error, devolvemos null!!
    }
}
