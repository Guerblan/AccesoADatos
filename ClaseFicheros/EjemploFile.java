/*
 * Esto es la clase File en java,así es la estructura,con ella conseguimos info
 * del fichero,si existo o no y características.
 */

import java.io.File;

public class EjemploFile {
    public static void main(String[] args) {
        File fichero = new File("datos.txt");
        System.out.println("Nombre: " + fichero.getName());
        // con ésto fichero.getAbsolutePath()conseguimos la ruta absoluta,desde C
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Existe?: " + fichero.exists());
    }
}
