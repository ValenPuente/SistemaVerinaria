package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorVeterinarios {
    // clase encargada de leer e interactuar con el archivo de veterinarios!! -->


    public boolean agregarVeterinarios(Veterinario vet) { // recibe una instancia de veterinario!

        // Construimos la línea que se va a escribir en el archivo, en el formato establecido!
        String linea = vet.getIdEmpleado() + "," + vet.getNombre() + "," + vet.getClave();

        // Si ya existe, no agregamos
        if (verificarVeterinarioExistente(vet)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("veterinarios.txt", true))) {
            writer.write(linea); // escribimos la línea en el archivo!!
            // y añadimos un salto de línea al final para el próximo registro
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de veterinarios: " + e.getMessage());
            return false;
        }
    }

    public boolean verificarVeterinarioExistente(Veterinario veterinario) {
        // metodo que verifica si un veterinario ya se encuentra registrado en el archivo!!
        String veterinarioABuscar = veterinario.getIdEmpleado() + "," + veterinario.getNombre() + "," + veterinario.getClave();
        try (BufferedReader reader = new BufferedReader(new FileReader("veterinarios.txt"))){
        // dentro del () tendrmos la acción que nos puede traer problemas!
            String linea; // tomará cada línea del archivo!!
            while ((linea = reader.readLine()) != null) {
                if (linea.equals(veterinarioABuscar)) { // usamos equals porque son dos String!
                    return true; // veterinario ya existe
                }
            }
        } catch(IOException e){ // si llegamos aquí es porque hubo un error al leer el archivo!!
            System.out.println("Error al leer el archivo de veterinarios: " + e.getMessage());
        }
        return false; // significa que el veterinario no existe!!!!
    }
}
