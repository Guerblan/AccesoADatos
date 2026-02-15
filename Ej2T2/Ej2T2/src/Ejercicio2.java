import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void Contar() {
        String nombreFichero = "entrada.txt";

        int numLineas = 0;
        int numCaracteres = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numLineas++;
                numCaracteres += linea.length();
            }
        } catch (IOException e) {
            System.err.println("No se ha podido leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Líneas: " + numLineas);
        System.out.println("Caracteres (sin saltos de línea): " + numCaracteres);
    }
}
