import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Tema1 {
    public static void ejercicio1() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta (puede ser fichero o directorio).
         * 
         * Cree un objeto File usando esa ruta.
         * 
         * Compruebe si la ruta existe o no.
         * 
         * Si NO existe:
         * 
         * Muestra un mensaje por System.err indicando que no existe.
         * 
         * Si SÍ existe:
         * 
         * Muestra un mensaje por System.out indicando que existe.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una ruta de un archivo o directorio");
        String ruta = sc.nextLine();

        File file = new File(ruta);
        if (file.exists()) {
            System.out.println("La ruta existe");
        } else {
            System.err.println("La ruta no existe");
        }
    }

    public static void ejercicio2() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta.
         * 
         * Cree un objeto File usando esa ruta.
         * 
         * Compruebe si la ruta existe o no.
         * 
         * Si NO existe:
         * 
         * Muestra un mensaje por System.err indicando que no existe.
         * 
         * Si SÍ existe:
         * 
         * Comprueba si la ruta es un fichero o un directorio.
         * 
         * Si es un fichero, muestra un mensaje por System.out.
         * 
         * Si es un directorio, muestra un mensaje por System.out.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);

        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("Es un fichero");
            } else if (file.isDirectory()) {
                System.out.println("Es un directorio");
            }
        } else {
            System.err.println("La ruta no existe");
        }
    }

    public static void ejercicio3() {
        /*
         * Enunciado
         * 
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta.
         * 
         * Cree un objeto File usando esa ruta.
         * 
         * Compruebe si la ruta existe o no.
         * 
         * Si NO existe:
         * 
         * Muestra un mensaje por System.err indicando que no existe.
         * 
         * Si SÍ existe:
         * 
         * Muestra por System.out:
         * 
         * El nombre del fichero o directorio.
         * 
         * La ruta tal y como fue introducida.
         * 
         * La ruta absoluta.
         * 
         * Indica además si es un fichero o un directorio.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);
        // Siempre file,ya que exists es un método de file.
        // Si usara ruta(string) no tendria sentido porque
        // exists no es un método de file
        if (file.exists()) {
            System.out.println("Nombre " + file.getName());
            // Aquí puedo usar ruta o file.getpath.
            System.out.println("Ruta original " + ruta);
            System.out.println("Ruta absoluta " + file.getAbsolutePath());
            System.out.println("Es fichero? " + file.isFile());
            System.out.println("Es un directorio? " + file.isDirectory());
        } else {
            System.err.println("La ruta no existe");
        }
    }

    public static void ejercicio4() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta de fichero (no directorio).
         * 
         * Cree un objeto File usando esa ruta.
         * 
         * Compruebe si el fichero existe o no.
         * 
         * Si SÍ existe:
         * 
         * Muestra un mensaje por System.out indicando que ya existe.
         * 
         * Si NO existe:
         * 
         * Intenta crear el fichero.
         * 
         * Si se crea correctamente, muestra un mensaje por System.out.
         * 
         * Si no se puede crear, muestra un mensaje por System.err.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame la ruta de un fichero");
        String rutaFichero = sc.nextLine();

        File file = new File(rutaFichero);

        if (file.exists()) {
            System.out.println("El fichero existe");
        } else {
            try {
                // vamos a crear un booleano para trabajar con él.Lo más óptimo
                boolean creado = file.createNewFile();
                if (creado) {
                    System.out.println("Fichero creado con éxito");
                } else {
                    System.err.println("Error al crear el fichero");
                }
            } catch (Exception e) {
                System.err.println("Error en la creación del fichero");
            }
        }
    }

    public static void ejercicio5() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta de directorio.
         * 
         * Cree un objeto File usando esa ruta.
         * 
         * Compruebe si la ruta existe o no.
         * 
         * Si SÍ existe:
         * 
         * Indica por System.out si lo que existe es un directorio o un fichero.
         * 
         * Si NO existe:
         * 
         * Intenta crear el directorio.
         * 
         * Si se crea correctamente, muestra un mensaje por System.out.
         * 
         * Si no se puede crear, muestra un mensaje por System.err.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la ruta de un directorio");
        String rutaDir = sc.nextLine();

        File file = new File(rutaDir);

        if (file.exists()) {
            System.out.println("Es directorio " + file.isDirectory());
            System.out.println("Es fichero " + file.isFile());
        } else {
            try {
                boolean creado = file.mkdir();
                if (creado) {
                    System.out.println("directorio creado correctamente");
                } else {
                    System.out.println("No se pudo crear el directorio");
                }

            } catch (Exception e) {
                System.out.println("Error en la creación del directorio");
            }
        }
    }

    public static void ejercicio6() {

    }

    public static void ejercicio7() {

    }

    public static void ejercicio8() {

    }

    public static void ejercicio9() {

    }

    public static void ejercicio10() {

    }

    public static void ejercicio11() {

    }

    public static void ejercicio12() {

    }

    public static void main(String[] args) {
        // ejercicio1();
        // ejercicio2();
        // ejercicio3();
        // ejercicio4();
        // ejercicio5();
        // ejercicio6();
        // ejercicio7();
        // ejercicio8();
        // ejercicio9();
        // ejericio10();
        // ejercicio12();
        // ejercicio13();
        // ejercicio14();
        // ejercicio15();
        // ejercicio16();
        // ejercicio17();
        // ejercicio18();
        // ejercicio19();
        // ejercicio20();
        // ejercicio21();
        // ejericio122();
    }
}
