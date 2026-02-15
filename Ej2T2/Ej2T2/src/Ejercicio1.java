import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;

public class Ejercicio1 {

    public static void crearNota() {

        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {

            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.err.println("No se ha podido crear el archivo" + e.getMessage());
        }
    }
}
