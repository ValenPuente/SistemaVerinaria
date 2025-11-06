package modelo;

import java.util.regex.Pattern;

public final class ValidadorConsulta {
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private static final Pattern PHONE = Pattern.compile("^[0-9+()\\-\\s]{6,20}$");
    private static final Pattern DIGITS = Pattern.compile("^\\d+$");

    public ValidadorConsulta() { }

    // devuelve mensaje de error específico o null si todo OK
    public String validarConMensaje(
            String nombreDuenio, String apellidoDuenio,
            String telefono, String email,
            String tipoMascota, String nombreMascota, String edadMascota,
            String condicion, Tratamiento tratamiento
    ) {
        if (blank(nombreDuenio)) return "ERROR: El nombre del dueño es obligatorio.";
        if (blank(apellidoDuenio)) return "ERROR: El apellido del dueño es obligatorio.";
        if (blank(email)) return "ERROR: El email es obligatorio.";
        if (!EMAIL.matcher(email).matches()) return "ERROR: El email tiene un formato inválido.";
        if (blank(telefono)) return "ERROR: El teléfono es obligatorio.";
        if (!PHONE.matcher(telefono).matches()) return "ERROR: El teléfono tiene un formato inválido.";
        if (blank(tipoMascota)) return "ERROR: El tipo de mascota es obligatorio.";
        if (blank(nombreMascota)) return "ERROR: El nombre de la mascota es obligatorio.";
        if (blank(edadMascota)) return "ERROR: La edad de la mascota es obligatoria.";
        if (!DIGITS.matcher(edadMascota).matches()) return "ERROR: La edad debe ser un número entero.";
        try {
            if (Integer.parseInt(edadMascota) < 0) return "ERROR: La edad no puede ser negativa.";
        } catch (NumberFormatException e) { return "ERROR: La edad tiene un formato inválido."; }
        if (blank(condicion)) return "ERROR: La condición/problema es obligatoria.";
        if (tratamiento == null) return "ERROR: Debe seleccionar un tratamiento.";
        return null; // todo OK
    }

    // Conserva el método boolean por compatibilidad, usando validarConMensaje
    public boolean validar(
            String nombreDuenio, String apellidoDuenio,
            String telefono, String email,
            String tipoMascota, String nombreMascota, String edadMascota,
            String condicion, Tratamiento tratamiento
    ){
        return validarConMensaje(nombreDuenio, apellidoDuenio, telefono, email, tipoMascota, nombreMascota, edadMascota, condicion, tratamiento) == null;
    }

    private boolean blank(String s){ return s == null || s.trim().isEmpty(); }
}