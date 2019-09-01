package cecar.edu.controlador;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase: ControladorArchivos
 * 
 * @version: 0.1
 *  
 * @since: 25/08/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Frank Camilo Atencio Loreth
 * 
 * Copyrigth: CECAR
 */

/**
* Clase que permite ejecutar métodos de manipulación de archivos.
* @see File cargarArchivo()
* @see ArrayList leerArchivo(String dir)
* @see guardarArchivo(ArrayList lineas, String nombre)
**/
public class ControladorArchivos {
    /**
    * Método que permite cargar un archivo con extensión txt.
    * @return FILE
    **/
    public static File cargarArchivo(){
        JFileChooser j = new JFileChooser();        
        String s;
        File f = null;
        FileNameExtensionFilter fn;
        
        try {
            fn = new FileNameExtensionFilter("Solo archivos txt", "txt");
            j.setFileFilter(fn);
            j.setAcceptAllFileFilterUsed(false);
            int r=j.showOpenDialog(null);
            if(r==JFileChooser.APPROVE_OPTION){
                s = j.getSelectedFile().getAbsolutePath();
                f = new File(s);   
                System.out.println("El archivo ha sido cargado.");
            }else{
                System.out.println("El archivo NO ha sido cargado.");
                System.exit(0);
            }
        } catch (HeadlessException | NullPointerException e) {
            System.out.println("Error al cargar archivo - Descripción del error: " + e.getMessage());
        }
        return f;
    }
    
    /**
    * Método que permite leer un archivo con extensión txt.
    * @param dir direccion del archivo    
    * @return ArrayList de String
    **/
    public static ArrayList<String> leerArchivo(String dir){
        ArrayList<String> lineas = null;
        FileReader fr=null;
        BufferedReader br=null;
        try {
            lineas = new ArrayList<>();
            fr = new FileReader(dir);
            br = new BufferedReader(fr);            
            String linea;
            while((linea=br.readLine())!=null){
                lineas.add(linea.replaceAll("ï»¿", ""));                
            }            
            fr.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return lineas;
    }
    
    /**
    * Método que permite guardar un archivo con extensión txt.    
     * @param lineas colección de cadenas String
     * @param nombre nombre del archivo de texto
    **/
    public static void guardarArchivo(ArrayList<String> lineas, String nombre){
        String ruta = System.getProperty("user.dir")+File.separator+"Archivos"+File.separator+nombre+".txt";
        File archivoSalida = new File(ruta);
        if(archivoSalida.exists()){
            archivoSalida.delete();
        }
        File archivoSalida2 = new File(ruta);
        BufferedWriter bw;
        try {
            
            bw = new BufferedWriter(new FileWriter(archivoSalida2));
            for (int i=0; i<lineas.size();++i) {
                bw.write(lineas.get(i));                
            }
            bw.close();
            System.err.println("El archivo ["+archivoSalida.getName()+"] ha sido creado.");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }        
}

