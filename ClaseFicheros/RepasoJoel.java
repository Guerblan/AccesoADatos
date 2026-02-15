import java.io.*; // ✅ Importa clases para leer/escribir ficheros (streams, readers, writers, buffers)
import java.nio.charset.StandardCharsets; // ✅ Para especificar UTF-8 de forma explícita

public static void pgbMetodo_seis(String entrada, String salida) { // ✅ Método: recibe ruta del CSV original y ruta del
                                                                   // CSV simplificado

    // ✅ PARTE 1 DEL ENUNCIADO:
    // "Leer el fichero peticion.csv en UTF-8"
    //
    // ✅ PARTE 2 DEL ENUNCIADO:
    // "Generar un fichero peticion_simplificada.csv (UTF-8) con:
    // id_peticion;id_nino;estado;fecha_peticion"
    //
    // ✅ PARTE 3 DEL ENUNCIADO:
    // "Incluir una cabecera adecuada"

    try (BufferedReader br = new BufferedReader( // ✅ Lector con buffer para leer texto línea a línea de forma eficiente
            new InputStreamReader( // ✅ Convierte bytes del fichero en caracteres (texto)
                    new FileInputStream(entrada), // ✅ Abre el fichero de entrada en modo lectura (como bytes)
                    StandardCharsets.UTF_8)); // ✅ Fuerza lectura en UTF-8 (no depende del sistema operativo)

            BufferedWriter bw = new BufferedWriter( // ✅ Escritor con buffer para escribir texto de forma eficiente
                    new OutputStreamWriter( // ✅ Convierte caracteres (texto) a bytes para guardarlos en fichero
                            new FileOutputStream(salida), // ✅ Abre/crea el fichero de salida en modo escritura
                                                          // (sobrescribe)
                            StandardCharsets.UTF_8))) { // ✅ Fuerza escritura en UTF-8

        // ✅ PARTE 1 / MANEJO DEL CSV ORIGINAL
        // Saltar cabecera del CSV original (porque no es un registro real)
        br.readLine(); // ✅ Lee y descarta la primera línea

        // ✅ PARTE 3 DEL ENUNCIADO: CABECERA ADECUADA EN EL SIMPLIFICADO
        bw.write("id_peticion;id_nino;estado;fecha_peticion"); // ✅ Escribe la cabecera que pide el enunciado en el
                                                               // nuevo CSV
        bw.newLine(); // ✅ Salto de línea (para empezar a escribir registros debajo)

        // ✅ PARTE 2 DEL ENUNCIADO: PROCESAR REGISTROS Y GENERAR CSV SIMPLIFICADO
        String linea; // ✅ Variable donde guardaremos cada línea del fichero original
        while ((linea = br.readLine()) != null) { // ✅ Lee una línea; si es null => fin del fichero

            String[] partes = linea.split(";"); // ✅ Divide la línea en columnas usando ';' como separador

            // ✅ SELECCIÓN DE CAMPOS (de todas las columnas originales, nos quedamos solo
            // con 4)
            String id_peticion = partes[0]; // ✅ Columna 0: id_peticion
            String id_nino = partes[1]; // ✅ Columna 1: id_nino
            String fecha_peticion = partes[3]; // ✅ Columna 3: fecha_peticion
            String estado = partes[5]; // ✅ Columna 5: estado

            // ✅ ESCRITURA EN EL ORDEN EXACTO QUE PIDE EL ENUNCIADO:
            // id_peticion;id_nino;estado;fecha_peticion
            bw.write(id_peticion + ";" + id_nino + ";" + estado + ";" + fecha_peticion); // ✅ Construye la nueva línea
                                                                                         // del CSV simplificado
            bw.newLine(); // ✅ Salto de línea para el siguiente registro
        }

        System.out.println("Generado: " + salida); // ✅ Mensaje informativo (útil en pruebas)

    } catch (IOException e) { // ✅ Captura errores de lectura/escritura de ficheros
        System.err.println("Error: " + e.getMessage()); // ✅ Muestra mensaje de error
    }
}
