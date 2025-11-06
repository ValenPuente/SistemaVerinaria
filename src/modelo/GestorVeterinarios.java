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
        String linea1 = vet.getIdEmpleado() + "," + vet.getNombre() + "," + vet.getApellido() + "," + vet.getClave();

        // Si ya existe, no agregamos
        if (verificarVeterinarioExistente(vet)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/datos/veterinariosLogs.txt", true))) {
            writer.write(linea1); // escribimos la línea en el archivo!!
            // y añadimos un salto de línea al final para el próximo registro
            writer.newLine();
            // no ponemos return true acá porque queremos agregarlo a otro txt también!!
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de veterinarios: " + e.getMessage());
            return false;
        }

        String linea2 = vet.getNombre() + "," + vet.getApellido();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/datos/veterinarios.txt", true))) {
            writer.write(linea2); // escribimos la línea en el archivo!!
            // y añadimos un salto de línea al final para el próximo registro dentro del txt!!
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de veterinarios: " + e.getMessage());
            return false;
        }
    }

    public boolean verificarVeterinarioExistente(Veterinario veterinario) {
        // metodo que verifica si un veterinario ya se encuentra registrado en el archivo!!
        // tomamos solo los datos del txt que guarda los logs de los veterinarios!!
        String veterinarioABuscar = veterinario.getIdEmpleado() + "," + veterinario.getNombre() + "," + veterinario.getApellido() + "," + veterinario.getClave();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/datos/veterinariosLogs.txt"))){
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

    public Veterinario elegirVeterinario(){
        // metodo que elige un veterinario aleatoriamente del txt de veterinarios!!
        try (BufferedReader reader = new BufferedReader(new FileReader("src/datos/veterinarios.txt"))){
            String linea;
            int contador = 0;
            while ((linea = reader.readLine()) != null) {
                contador++;
            }
            // generamos un número aleatorio entre 0 y contador-1
            int numeroAleatorio = (int) (Math.random() * contador);
            // volvemos a leer el archivo para llegar a la línea del número aleatorio
            reader.close(); // cerramos el reader anterior
            BufferedReader reader2 = new BufferedReader(new FileReader("src/datos/veterinarios.txt"));
            int indiceActual = 0;
            while ((linea = reader2.readLine()) != null) {
                if (indiceActual == numeroAleatorio) {
                    // separamos los datos de la línea para crear la instancia de Veterinario
                    String[] datos = linea.split(",");
                    Veterinario vetSeleccionado = new Veterinario(datos[0], datos[1]);
                    reader2.close();
                    return vetSeleccionado; // retornamos el veterinario creada con nombre y apellido
                    // solamente!
                }
                indiceActual++;
            }
            reader2.close();
        } catch(IOException e){
            System.out.println("Error al leer el archivo de veterinarios: " + e.getMessage());
        }
        return null; // en caso de error o si no se encuentra ningún veterinario
    }


    public boolean validaridEmpleado(String idEmpleado) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/datos/veterinariosLogs.txt"))) {
            // dentro del () tendrmos la acción que nos puede traer problemas!
            String linea; // tomará cada línea del archivo!!
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); // dividimos la línea en partes
                if (datos[0].equals(idEmpleado)) {
                    return false; // veterinario ya existe
                }
            }
        } catch (IOException e) { // si llegamos aquí es porque hubo un error al leer el archivo!!
            System.out.println("Error al leer el archivo de veterinarios: " + e.getMessage());
        }
        return true;
    }


}