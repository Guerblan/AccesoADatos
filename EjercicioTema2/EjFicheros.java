import java.io.File;
import java.io.IOException;

public class EjFicheros {
    public static void ejercicio1() {
        /*
         * Ejercicio 1: Comprobando información de un fichero
         * 1. Crea un programa que reciba la ruta de un fichero (por ejemplo,
         * "ejemplo.txt").
         * 2. Muestra en consola:
         * ○ El nombre del fichero.
         * ○ La ruta absoluta.
         * ○ Si existe o no.
         * ○ Si es fichero o directorio.
         * �
         * �
         * Usa System.out para la información y System.err para indicar si el fichero no
         * existe.
         * �
         * �
         */

        try {

            File file = new File("datos.txt");
            System.out.println("Nombre:" + file.getNombre());
            System.out.println("Ruta absoluta:" + file.getAbsolutePath());
            System.out.println("Existe?" + file.exists());
            System.out.println("Es fichero?" + file.isFile());
            System.out.println("Es directorio?" + file.isDirectory());
        } catch (Exception e) {
            System.err.println("No es posible crea el archivo");
        }

    }

    public static void ejercicio2() {
        /*
         * Ejercicio 2: Creación de ficheros
         * 1. Crea un programa que intente crear un fichero llamado datos.txt.
         * 2. Si el fichero ya existía, muestra un aviso en consola (System.out).
         * 3. Si el fichero se crea correctamente, muestra un mensaje de éxito.
         * 4. Si ocurre un error (IOException), captura la excepción y muestra el error
         * con
         * System.err.
         * �
         * �
         */
        try {
            File file = new File("nuevofichero.txt");
            if (file.createNewFile()) {
                System.out.println("Fichero creado " + getNombre());
            } else {
                System.out.println("El fichero ya existe");
            }

        } catch (IOException e) {
            System.out.println("Error al crear fichero " + e.getMessage());
        }
    }

    public static void ejercicio3() {
        /*
         * Ejercicio 3: Crear directorios
         * 1. Escribe un programa que cree una carpeta llamada miDirectorio.
         * 2. Comprueba si se ha creado correctamente (mkdir()).
         * 3. Muestra un mensaje de éxito o error según corresponda.
         * �
         * �
         */
        try {
            File dir = new File("miDirectorio");
            System.out.println("Directorio creado " + getNombre());
            if (dir.mkdir()) {
                System.out.println("Ya existe ese directorio");
            }
        } catch (Exception e) {
            System.err.println("Error al crear el directorio " + e.getMessage());
        }
    }

    public static void ejercicio4() {
        /*
         * Ejercicio 4: Listado de ficheros en un directorio
         * 1. Dentro de miDirec-torio, crea manualmente un par de ficheros de prueba
         * (ej.
         * a.txt, b.txt).
         * 2. Escribe un programa que liste el contenido de la carpeta usando list().
         * 3. Diferencia entre directorios y ficheros usando isFile() e isDirectory().
         * �
         * �
         */

        try {
            String rutaA = "C:\\Users\\MaikGAMST\\Desktop\\ejercicioFicherosAD\\miDirectorio\\a.txt";
            String rutaB = "C:\\Users\\MaikGAMST\\Desktop\\ejercicioFicherosAD\\miDirectorio\\b.txt";
            String rutaC = "C:\\Users\\MaikGAMST\\Desktop\\ejercicioFicherosAD\\miDirectorio";

            try {
                File fileA = new File(rutaA);
                File fileB = new File(rutaB);
                File directorio = new File(rutaC);

                if (fileA.createNewFile()) {
                    System.out.println("Fichero creado: " + fileA.getName());
                }
                if (fileB.createNewFile()) {
                    System.out.println("Fichero creado existosamente: " + fileB.getName());
                } else {
                    System.out.println("El fichero ya existe");
                } 

                System.out.println("Contenido de: " + directorio.getName());
                String[] lista = directorio.list();

                if (lista != null) {
                    for (String nombre : lista) {
                        System.out.println(nombre);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error al crear archivo: " + e.getMessage());
            }

        } catch (Exception e) {

        }
    }

    public static void ejercicio5() {
        /*
         * 
         * Ejercicio 5: Manejo de excepciones con lectura
         * 1. Escribe un programa que intente abrir el fichero noexiste.txt usando
         * Scanner.
         * 2. Captura la excepción FileNotFoundException.
         * 3. Muestra un mensaje de error con System.err.
         * �
         * �
         * Retos extra (para profundizar)
         * ● Reto 1: Programa que elimine un fichero si existe, y que muestre mensajes
         * adecuados en consola.
         * ● Reto 2: Programa que muestre el tamaño en bytes de un fichero (length()), y
         * que
         * al no existir muestre error en System.err.
         * ● Reto 3: Programa que cree un subdirectorio dentro de miDirectorio y luego
         * muestre todo el árbol de ficheros/directorios con sangrado (simulando un
         * pequeño
         * “explorador de archivos”).
         */
    }
}

public static void main(String[] args) throws Exception {
    // ejercicio1();
    // ejercicio2();
    // ejercicio3();
    // ejercicio4();
    // ejercicio5();
    // ejercicio6();

}
