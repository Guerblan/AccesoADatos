import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class InfoRutas {
    public static void main(String[] args) {

        File archivoObjetivo = new File("prueba.txt");
        System.out.println("Ruta absoluta de prueba.txt -> " + archivoObjetivo.getAbsolutePath());
        System.out.println("¿Existe prueba.txt?: " + archivoObjetivo.exists());
        try {
            boolean creado = archivoObjetivo.createNewFile(); // crea el fichero si no existía
            System.out.println("¿Archivo creado ahora?: " + creado);
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo: " + e.getMessage());
        }
        System.out.println("¿Es archivo (isFile)? " + archivoObjetivo.isFile());
        System.out.println("¿Es directorio (isDirectory)? " + archivoObjetivo.isDirectory());
        File carpetaObjetivo = new File("miCarpetaPrueba");

        boolean carpetaCreada = carpetaObjetivo.mkdir();
        System.out.println("¿Carpeta creada?: " + carpetaCreada);
        System.out.println("¿Existe?: " + carpetaObjetivo.exists());
        System.out.println("¿Es directorio?: " + carpetaObjetivo.isDirectory());
        File archivoDentro = new File(carpetaObjetivo, "nota.txt");

        System.out.println("Ruta absoluta del archivo dentro: " + archivoDentro.getAbsolutePath());
        System.out.println("¿Existe archivo dentro?: " + archivoDentro.exists());
        try {
            boolean creadoDentro = archivoDentro.createNewFile();
            System.out.println("¿Archivo nota.txt creado dentro?: " + creadoDentro);
        } catch (IOException e) {
            System.out.println("No se pudo crear nota.txt: " + e.getMessage());
        }
        try (FileWriter escritor = new FileWriter(archivoDentro, false)) { // true = añadir
            escritor.write("SEGUNDA ESCRITURA\n");
        } catch (IOException e) {
            System.out.println("No se pudo escribir en nota.txt: " + e.getMessage());
        }

        System.out.println("Tamaño de nota.txt (bytes): " + archivoDentro.length());
        System.out.println("Última modificación (millis): " + archivoDentro.lastModified());

        System.out.println("¿nota.txt es archivo (isFile)?: " + archivoDentro.isFile());
        System.out.println("¿nota.txt es directorio (isDirectory)?: " + archivoDentro.isDirectory());
        File[] elementosEnCarpeta = carpetaObjetivo.listFiles();
        System.out.println("Contenido de la carpeta:");

        if (elementosEnCarpeta != null) {
            for (File elemento : elementosEnCarpeta) {
                System.out.println(" - " + elemento.getName());
            }
        }
        System.out.println("Tamaño de nota.txt (bytes): " + archivoDentro.length());
        System.out.println("Última modificación (millis): " + archivoDentro.lastModified());
        try (FileReader lector = new FileReader(archivoDentro)) {
            int codigoCaracter;
            System.out.print("Contenido leído desde nota.txt: ");
            while ((codigoCaracter = lector.read()) != -1) { // -1 = fin de archivo
                System.out.print((char) codigoCaracter);
            }
            System.out.println(); // salto de línea al final
        } catch (IOException e) {
            System.out.println("No se pudo leer nota.txt: " + e.getMessage());
        }
        /*
         * boolean borradoNota = archivoDentro.delete();
         * System.out.println("¿nota.txt borrado?: " + borradoNota);
         */

        try (BufferedReader lectorLineas = new BufferedReader(new FileReader(archivoDentro))) {
            String linea;
            System.out.println("Leyendo por líneas:");
            while ((linea = lectorLineas.readLine()) != null) { // null = fin de archivo
                System.out.println("> " + linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer por líneas: " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDentro, true))) { // true = añadir
            bw.write("Línea A escrita con BufferedWriter");
            bw.newLine(); // salto de línea portable
            bw.write("Línea B escrita con BufferedWriter");
            bw.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo escribir con BufferedWriter: " + e.getMessage());
        }
        System.out.println("Tamaño (bytes): " + archivoDentro.length());
        System.out.println("Última modificación: " + archivoDentro.lastModified());
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoDentro, true))) {
            escritor.write("---- Registro nuevo ----");
            escritor.newLine(); // salto de línea
            escritor.write("Autor: Pedro");
            escritor.newLine();
            escritor.write("Fecha: " + java.time.LocalDate.now());
            escritor.newLine();
            escritor.write("Mensaje: Estoy entendiendo los ficheros de texto en Java!");
            escritor.newLine();
            escritor.newLine(); // doble salto final
        } catch (IOException e) {
            System.out.println("Error al escribir registro: " + e.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivoDentro))) {
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            System.out.println("=== Archivo completo en memoria ===");
            System.out.println(contenido.toString());

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo completo: " + e.getMessage());
        }

    }
}
