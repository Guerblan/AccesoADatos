import java.util.Scanner;

// import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    Scanner sca = new Scanner(System.in);
    private int id = 0;
    private String nombre = "";
    private double tamaño = 0;
    private String extension = "";
    private String autor = "";
    List<File> listaFicheros = new ArrayList<>();

    /*
     * Añadir Fichero (Se pedirá el nombre completo y el tamaño)
     * Modificar Fichero (Dado un ID)
     * Listar Ficheros
     * Borrar Fichero (Dado un ID)
     * Buscar fichero por nombre o extensión (Se dará un único string de búsqueda).
     * Por ejemplo: Buscar: rest.txt | Buscar: rest | Buscar t.txt ...
     * Salir
     * Detalles:
     * De cada fichero se almacenará su id (único), nombre, extensión y tamaño. El
     * id será autogenerado.
     * De un fichero se podrá modificar su nombre, extensión o tamaño.
     * En el menú se deberá controlar si el usuario introduce un número distinto al
     * listado. Controlar si es una entrada no numérica.
     * Almacenar información sobre el autor del fichero.
     * Mostrar el ID del fichero como 2 dígitos. Por ejemplo: Fichero 1 sería
     * Fichero 01. Fichero 3 sería Fichero 03.
     */
    /*
     * declarar variables inckuyendo list de fichero
     * 
     */
    public void añadirFichero() {
        System.out.println("Introduce un nombre");
        nombre = sca.nextLine();
        System.out.println("Introduce un tamaño");
        tamaño = sca.nextDouble();
        sca.nextLine();
        System.out.println("Introduce un extensión");
        extension = sca.nextLine();
        System.out.println("Introduce un autor");
        autor = sca.nextLine();
        File f = new File(nombre, tamaño, extension, autor);
        listaFicheros.add(f);
    }

    public void modificarFichero() {
        /*
         * Aquí tengo que modificar un onjeto fichero que sea el que haya metido
         * el id correspndiente
         */
        System.out.println("Introducce el id del ficheroa modificar");
        id = sca.nextInt();
        sca.nextLine();
        for (File elemento : listaFicheros) {
            if (elemento.getId() == id) {
                System.out.println("Introduce un nombre");
                nombre = sca.nextLine();
                System.out.println("Introduce un tamaño");
                tamaño = sca.nextDouble();
                sca.nextLine();
                System.out.println("Introduce un extensión");
                extension = sca.nextLine();
                System.out.println("Introduce un autor");
                autor = sca.nextLine();
                elemento.setNombre(nombre);
                elemento.setTamaño(tamaño);
                elemento.setExtension(extension);
                elemento.setAutor(autor);
            }
        }
    }

    public void borrarFichero() {
        System.out.println("Introduce el id del fichero a borrar");
        id = sca.nextInt();
        sca.nextLine();

        Iterator<File> iterator = listaFicheros.iterator();
        while (iterator.hasNext()) {
            File elemento = iterator.next();
            if (id == elemento.getId()) {
                iterator.remove();
                System.out.println("Fichero con id " + id + " eliminado.");
                break;
            }
        }
    }

    public void buscarFicheroPorNombre() {
        System.out.println("Introduce el nombre del fichero o extensión que desees buscar");
        String busqueda = sca.nextLine();
        for (File elemento : listaFicheros) {
            if (busqueda.contains(elemento.getNombre()) || busqueda.contains(elemento.getExtension())) {
                System.out.println(elemento);
            }
        }
    }

    public void menu() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("1.AñadirFichero");
            System.out.println("2.modificarFichero");
            System.out.println("3.buscarFichero");
            System.out.println("4.borrarFichero");
            System.out.println("5.listar");
            System.out.println("6.Salir");
            System.out.println("Elige una opción");
            opcion = sca.nextInt();
            sca.nextLine();
            switch (opcion) {
                case 1:
                    añadirFichero();
                    break;
                case 2:
                    modificarFichero();
                    break;
                case 3:
                    buscarFicheroPorNombre();
                    break;
                case 4:
                    borrarFichero();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    System.out.println("Adiós");
                    break;
                default:
                    break;
            }

        }
    }

    public void listar() {
        for (File elemento : listaFicheros) {
            System.out.println(elemento);
        }
    }

    public void añadirFicherosInicialmente() {

        File elemento1 = new File("Pedro", 15, "html", "Quevedo");
        listaFicheros.add(elemento1);
        File elemento2 = new File("Luis", 13, "txt", "Quevedo");
        listaFicheros.add(elemento2);
        File elemento3 = new File("María", 13, "html", "Quevedo");
        listaFicheros.add(elemento3);
        File elemento4 = new File("Juan", 13, "txt", "Quevedo");
        listaFicheros.add(elemento4);

    }

    public static void main(String[] args) {

        FileSystem e = new FileSystem();

        e.añadirFicherosInicialmente();
        System.out.println("prueba1");
        e.listar();
        e.menu();

    }
}
