import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void Guardar() {
        String nombreFichero = "mensajes.txt";

        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true))) {
            String frase;

            System.out.println("Escribe frases. Pulsa Enter en vacío para terminar:");

            while (true) {
                frase = sc.nextLine();
                // si está vacía, termina
                if (frase.isEmpty()) {
                    break;
                }

                bw.write(frase);
                bw.newLine();
            }

            System.out.println("Frases guardadas correctamente en " + nombreFichero);

        } catch (IOException e) {
            System.err.println("No se ha podido escribir en el archivo: " + e.getMessage());
        }

        sc.close();
    }
}
