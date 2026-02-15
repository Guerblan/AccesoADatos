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
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta.
         * 
         * Cree un objeto File con esa ruta.
         * 
         * Si la ruta NO existe:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta existe pero NO es un directorio:
         * 
         * Muestra un mensaje por System.err indicando que no es un directorio y
         * termina.
         * 
         * Si la ruta existe y es un directorio:
         * 
         * Obtén la lista de elementos que contiene (archivos y subcarpetas).
         * 
         * Muestra por System.out uno por línea el nombre de cada elemento.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);

        if (file.exists()) {
            boolean isDirectory = file.isDirectory();
            if (isDirectory) {
                /*
                 * Creo una lista que contiene el listado de los elementos del objeto file
                 * Después recorro cada elemento y muestro su nombre
                 */
                File[] elementos = file.listFiles();
                // Para cada elemento f de la lista elementos muestro el nombre
                for (File f : elementos) {
                    System.out.println(f.getName());
                }
            } else {
                System.err.println("No es un directorio");
            }
        } else {
            System.err.println("La ruta no existe");
        }

    }

    public static void ejercicio7() {
        /*
         * Enunciado
         * 
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta.
         * 
         * Cree un objeto File con esa ruta.
         * 
         * Si la ruta NO existe:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta existe pero NO es un directorio:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta existe y es un directorio:
         * 
         * Recorre su contenido.
         * 
         * Muestra por System.out solo los nombres de los ficheros.
         * 
         * No mostrar los directorios.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);

        if (file.exists()) {
            boolean isDirectory = file.isDirectory();
            if (isDirectory) {
                File[] elementos = file.listFiles();
                for (File f : elementos) {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    }
                }

            } else {
                System.err.println("No es un directorio");
            }
        } else {
            System.err.println("La ruta no existe");
        }
    }

    public static void ejercicio8() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado:
         * 
         * una ruta de directorio
         * 
         * una extensión (por ejemplo: txt, java, pdf)
         * 
         * Cree un objeto File con la ruta introducida.
         * 
         * Si la ruta NO existe:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta existe pero NO es un directorio:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta existe y es un directorio:
         * 
         * Recorre su contenido.
         * 
         * Muestra por System.out solo los nombres de los ficheros cuya extensión
         * coincida con la introducida.
         * 
         * No mostrar los directorios.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta de un directorio");
        String rutaDir = sc.nextLine();
        System.out.println("Introduce una extensión");
        String extension = sc.nextLine();

        File file = new File(rutaDir);

        if (file.exists()) {
            boolean isDirectory = file.isDirectory();
            if (isDirectory) {
                File[] elementos = file.listFiles();
                for (File f : elementos) {
                    if (f.isFile() && f.getName().endsWith("." + extension)) {
                        System.out.println(f.getName());
                    }
                }
            } else {
                System.err.println("No es un directorio");
            }
        } else {
            System.err.println("La ruta no existe");
        }
    }

    public static void ejercicio9() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado una ruta (puede ser fichero o directorio).
         * 
         * Cree un objeto File con esa ruta.
         * 
         * Si la ruta NO existe:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta SÍ existe:
         * 
         * Muestra por System.out:
         * 
         * El nombre.
         * 
         * La ruta introducida.
         * 
         * La ruta absoluta.
         * 
         * El tamaño (en bytes).
         * 
         * La fecha de última modificación.
         * 
         * Si tiene permiso de lectura.
         * 
         * Si tiene permiso de escritura.
         * 
         * Indica claramente si es:
         * 
         * un fichero
         * 
         * o un directorio.
         * 
         * Si es un directorio:
         * 
         * Indica cuántos ficheros contiene.
         * 
         * Indica cuántos directorios contiene.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);

        if (!file.exists()) {
            System.err.println("Ruta inexistente");
        } else {

            System.out.println("Nombre de la ruta: " + file.getName());
            System.out.println("Ruta introducida: " + ruta);
            System.out.println("Ruta absoluta: " + file.getAbsolutePath());
            System.out.println("Tamaño: " + file.length());
            System.out.println("Última modificación " + file.lastModified());
            System.out.println("Tiene permiso de lectura? " + file.canRead());
            System.out.println("Tiene permiso de escritura? " + file.canWrite());

            if (file.isFile()) {
                System.out.println("Es fichero");
            }
            if (file.isDirectory()) {
                System.out.println("Es directorio");
                // Primero creo una lista en la que listo todos los elementos dentro del
                // directorio
                File[] elementos = file.listFiles();
                // creo 2 variables para contar ficheros o directorios
                int numFicheros = 0;
                int numDirectorios = 0;
                // Si no son nulos empiezo un conteo
                if (elementos != null) {
                    for (File f : elementos) {
                        if (f.isFile()) {
                            numFicheros++;
                        }
                        if (f.isDirectory()) {
                            numDirectorios++;
                        }
                    }
                    System.out.println("Número de ficheros: " + numFicheros);
                    System.out.println("Nçumero de directorios " + numDirectorios);

                }

            }
        }

    }

    public static void ejercicio10() {
        /*
         * Haz un programa en Java que:
         * 
         * Pida por teclado:
         * 
         * una ruta existente (puede ser fichero o directorio)
         * 
         * un nuevo nombre (sin ruta, solo el nombre)
         * 
         * Cree un objeto File con la ruta introducida.
         * 
         * Si la ruta NO existe:
         * 
         * Muestra un mensaje por System.err y termina.
         * 
         * Si la ruta SÍ existe:
         * 
         * Obtén la ruta del directorio padre.
         * 
         * Crea un nuevo objeto File que represente la ruta con el nuevo nombre.
         * 
         * Intenta renombrar la ruta original al nuevo nombre.
         * 
         * Si el renombrado se realiza correctamente:
         * 
         * Muestra un mensaje por System.out.
         * 
         * Si no se puede renombrar:
         * 
         * Muestra un mensaje por System.err.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una ruta");
        String ruta = sc.nextLine();

        File file = new File(ruta);

        if (!file.exists()) {
            System.out.println("Ruta inexistente");
        } else {
            // pedimos el nuevo nombre
            System.out.println("Dame el nuevo nombre");
            String nuevoNombre = sc.nextLine();
            File padre = file.getParentFile();
            File destino = new File(padre, nuevoNombre);
            if (file.renameTo(destino)) {
                System.out.println("Renombreado correctamente");
            } else {
                System.err.println("Error al renombrar");
            }
        }

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
