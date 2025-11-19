import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TareaFicheros {
    public static void main(String[] args) {
        // Aquí vamos a crear una ruta y comprobar que existe,sólo eso,para tener la
        // referencia
        File f = new File("alumnos.csv");

        System.out.println("Ruta del archivo: " + f.getAbsolutePath());
        System.out.println("Nombre: " + f.getName());
        System.out.println("Existe?: " + f.exists());
        // Aquí abrimos el fuchero con Buffer
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;

            int totalAlumnos = 0;
            boolean esPrimera = true; // para saltar la cabecera
            int sumaNotas = 0;
            int aprobados = 0;

            // Moda: repeticiones de notas (0..10)
            int[] repeticiones = new int[11];

            // --- Especialidades (versión sencilla con arrays paralelos) ---
            String[] espNombres = new String[50]; // tope simple de especialidades
            int[] espSuma = new int[50]; // suma de notas por especialidad
            int[] espConteo = new int[50]; // nº alumnos por especialidad
            int numEsp = 0; // cuántas posiciones están en uso

            // Lectura línea a línea saltando cabecera
            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false;
                    continue;
                }

                // Aquí extraemos posiciones que nos servirán de referencia para extraer
                // nombres,especialidades y notas
                int sepPrimero = linea.indexOf(';');
                int sepUltimo = linea.lastIndexOf(';');
                String especialidad = linea.substring(sepPrimero + 1, sepUltimo).trim();
                String notaStr = linea.substring(sepUltimo + 1).trim();
                // Así pasamos la nota,que está en texto a número
                int nota = Integer.parseInt(notaStr);

                sumaNotas += nota;
                totalAlumnos++;

                if (nota >= 5) {
                    aprobados++;
                }

                // Frecuencias para la moda
                if (nota >= 0 && nota <= 10) {
                    repeticiones[nota]++;
                }

                // --- Actualizar especialidad (buscar o crear) ---
                int pos = -1;
                for (int i = 0; i < numEsp; i++) {
                    if (espNombres[i] != null && espNombres[i].equals(especialidad)) {
                        pos = i;
                        break;
                    }
                }
                if (pos == -1) { // no estaba: crear nueva entrada
                    espNombres[numEsp] = especialidad;
                    espSuma[numEsp] = 0;
                    espConteo[numEsp] = 0;
                    pos = numEsp;
                    numEsp++;
                }
                espSuma[pos] += nota;
                espConteo[pos] += 1;
            }

            // Cálculo de la moda
            int moda = 0;
            int maxFreq = -1;
            for (int i = 0; i < repeticiones.length; i++) {
                if (repeticiones[i] > maxFreq) {
                    maxFreq = repeticiones[i];
                    moda = i;
                }
            }


            double promedio = (double) sumaNotas / totalAlumnos;


            double porceApro = (aprobados * 100.0) / totalAlumnos;
            double porceSusp = 100.0 - porceApro;

    
            System.out.println("Total de alumnos: " + totalAlumnos);
            System.out.println("Nota promedio: " + promedio);
            System.out.println("Moda: " + moda + " (veces: " + maxFreq + ")");
            System.out.println("% Aprobados: " + porceApro);
            System.out.println("% Suspensos: " + porceSusp);

            // Medias por especialidad
            System.out.println("=== Medias por especialidad ===");
            for (int i = 0; i < numEsp; i++) {
                double mediaEsp = (double) espSuma[i] / espConteo[i];
                System.out.println(espNombres[i] + " -> media: " + mediaEsp
                        + " (" + espConteo[i] + " alumnos)");
            }
            // Ahora emezamos a escribir resultados en el salida.txt
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
                bw.write("Ruta del archivo: " + f.getAbsolutePath());
                bw.newLine();
                bw.write("Nombre: " + f.getName());
                bw.newLine();
                bw.write("Existe?: " + f.exists());
                bw.newLine();
                bw.newLine();

                bw.write("Total de alumnos: " + totalAlumnos);
                bw.newLine();
                bw.write("Nota promedio: " + promedio);
                bw.newLine();
                bw.write("Moda: " + moda + " (veces: " + maxFreq + ")");
                bw.newLine();
                bw.write("% Aprobados: " + porceApro);
                bw.newLine();
                bw.write("% Suspensos: " + porceSusp);
                bw.newLine();
                bw.newLine();

                bw.write("Medias por especialidad");
                bw.newLine();
                for (int i = 0; i < numEsp; i++) {
                    double mediaEsp = (double) espSuma[i] / espConteo[i];
                    bw.write(espNombres[i] + " -> media: " + mediaEsp
                            + " (" + espConteo[i] + " alumnos)");
                    bw.newLine();
                }
                // bw.flush(); // no imprescindible: try-with-resources cierra y vacía el buffer
            }

        } catch (IOException e) {
            System.err.println("Error al abrir/cerrar el archivo " + e.getMessage());
        }
    }
}