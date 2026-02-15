import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void GuardarMensajes() {
        String nombreFichero = "frases.txt";

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la palabra clave: ");
        String clave = sc.nextLine();
        sc.close();

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                if (linea.indexOf(clave) != -1) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            System.err.println("No se ha podido leer el archivo: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            System.out.println("No se encontraron resultados");
        }
    }
}
