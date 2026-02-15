import java.io.File;
import java.io.IOException;

public class CrearFichero {
    public static void main(String[] args) {
        try {
            File fichero = new File("noexiste.txt");
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " +
                        fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " +
                    e.getMessage());
        }
    }
}