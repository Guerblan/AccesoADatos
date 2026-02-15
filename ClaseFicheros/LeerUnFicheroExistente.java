import java.io.File;
import java.util.Scanner;

public class LeerUnFicheroExistente {

public void pgbMetodo_seis(String entrada,String salida){
         
   try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(entrada))),StandardCharsets.UTF_8;
       BufferedWriter br = new BufferedWriter(new OutputStreamWrite(new FileOutputStream(salida))),StandardCharsets.UTF_8) {
    br.readLine();
    br.write("id_petición;id_nino;fecha_peticion;estado");
    br.newLine();
    String linea;
    while ((linea=br.newLine()!=null)) {
       String partes [] = linea.split(";");
       String id_peticion = partes[0];
       String id_nino = partes[1];
       String fecha_peticion = partes[3];
       String estado = partes[5];

       br.write(id_peticion + ";" + id_nino + ";" + fecha_peticion + ";" + estado);
       br.newLine();

    }
    System.out.println("Generado: " + salida);
   } catch (IOException e) {
    System.out.println("Error al leer/escribir");
   }

}

}

public void pgbMetodo_siete(String entrada,String salida){
    try(RandomAccessFile raf = new RandomAccessFile(entrada, "r");
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(salida),StandardCharsets.UTF_8))) {
    raf.redLine();
    String linea;
    while(true){
        long pos = raf.getFilePointer();
        linea = raf.readLine();

        if(linea==null){
            break;
        }

        String [] partes = linea.split(";");
        String id_peticion = partes[0];
        bw.write(id_peticion + ":" pos);
        bw.newLine();
    }
    System.out.println(salida);

        
    } catch (IOException e) {
        System.out.println("Error al leer/esrcibir");
    }
}

    public static void main(String[] args) {

    }

    import java.io.*;
    import java.nio.charset.StandardCharsets;

    public static void pgbMetodo_siete(String rutaCsvSimplificado, String rutaIdx) {
        try (RandomAccessFile raf = new RandomAccessFile(rutaCsvSimplificado, "r");
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(rutaIdx), StandardCharsets.UTF_8))) {

            raf.readLine();

            String linea;
            while (true) {
                long pos = raf.getFilePointer();
                linea = raf.readLine();
                if (linea == null)
                    break;

                String[] partes = linea.split(";");
                String id_peticion = partes[0];

                bw.write(id_peticion + ":" + pos);
                bw.newLine();
            }

            System.out.println("Índice generado: " + rutaIdx);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
}


















