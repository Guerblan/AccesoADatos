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

/*Esta clase se encarga de  gestionar los ficheros y tiene una interfaz con las distintas
 * opciones las cuales podrá el usuario ir eligiendo:
 1)añadir fiecheros
 2)Modificar un ficehro por id
 3)Buscar ficheros por nombre o extensión
 4)Borrar fichero
 5)Listar todos los ficehros
 6)Salir
 */

import java.util.Scanner;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    Scanner sca = new Scanner(System.in);
    // variabls para ir guardando lo que el usuario dice
    private int id = 0;
    private String nombre = "";
    private double tamaño = 0;
    private String extension = "";
    private String autor = "";
    // La lista de ficheros la guardo en un ArrayList
    List<File> listaFicheros = new ArrayList<>();

    // primera opción:Aquí vamos incorporando ficheros al sistema
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

    // aquí vamos a modificar un fichero
    public void modificarFichero() {
        System.out.println("Introducce el id del ficheroa modificar");
        id = sca.nextInt();
        sca.nextLine();
        // recorro la lista hasta encontrar el id
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
                // actualizo el fichero
                elemento.setNombre(nombre);
                elemento.setTamaño(tamaño);
                elemento.setExtension(extension);
                elemento.setAutor(autor);
            }
        }
    }

    // borra fichero
    public void borrarFichero() {
        System.out.println("Introduce el id del fichero a borrar");
        id = sca.nextInt();
        sca.nextLine();
        // uso un interator para borrar mientras recorro
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

    // buscar ficehros por nombre o extensión
    public void buscarFicheroPorNombre() {
        System.out.println("Introduce el nombre del fichero o extensión que desees buscar");
        String busqueda = sca.nextLine();
        // si el string de búsqueda contiene el nobre o la extensión lo muestro
        for (File elemento : listaFicheros) {
            if (busqueda.contains(elemento.getNombre()) || busqueda.contains(elemento.getExtension())) {
                System.out.println(elemento);
            }
        }
    }

    // menú principal
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

    // listar ficehros
    public void listar() {
        for (File elemento : listaFicheros) {
            System.out.println(elemento);
        }
    }

    public void añadirFicherosInicialmente() {
        // cargo ficehros a la lista para no partir de 0
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
