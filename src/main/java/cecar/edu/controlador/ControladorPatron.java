package cecar.edu.controlador;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase: ControladorPatron
 * 
 * @version: 0.1
 *  
 * @since: 30/08/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Frank Camilo Atencio Loreth
 * 
 * Copyrigth: CECAR
 */

/**
* Clase que permite ejecutar métodos mediante comandos utilizando expresiones regulares.
* @see generarResumenExp(String comando, File f)
* @see contadorPalabrasExp(String comando, File f)
* @see obtenerpalabrasComunesExp(String comando, File f)
* @see obtenerCadenaLargaCortaExp(String comando, File f)
**/
public class ControladorPatron {        
    
    /**
    * Método que permite ejecutar el comando:
    * analizadorTexto [nombre del archivo]
    * @param comando comando
    * @param f archivo
    **/
    public static void generarResumenExp(String comando, File f){
        Pattern patron = Pattern.compile("analizadorTexto " +f.getName());
        Matcher encaja = patron.matcher(comando);
        if(encaja.find())
            ControladorMetodos.generarResumen(f.getAbsolutePath());        
    }
    
    /**
    * Método que permite ejecutar los comandos:
    * analizadorTexto -c [palabra a buscar]  [nombre del archivo]    
    * @param comando comando
    * @param f archivo
    **/
    public static void contadorPalabrasExp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -c " + v[2] +" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            if(encaja.find())
                ControladorMetodos.contarCadenaRepetida(f.getAbsolutePath(), v[2]);                      
        } catch (Exception e) {
        }                
    }
    
    /**
    * Método que permite ejecutar los comandos:
    * analizadorTexto -d [nombre del archivo]
    * analizadorTexto -d [número de palabras comunes] [nombre del archivo]
    * @param comando comando
    * @param f archivo
    **/
    public static void obtenerpalabrasComunesExp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron1 = Pattern.compile("analizadorTexto -d " + f.getName());
            Pattern patron2 = Pattern.compile("analizadorTexto -d " + v[2] +" "+f.getName());
            Matcher encaja1 = patron1.matcher(comando);
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja1.find())
                ControladorMetodos.generarLaPalabraMasFrecuente(f.getAbsolutePath());
            else if(encaja2.find() && Integer.parseInt(v[2])>0)
                ControladorMetodos.generarPalabrasFrecuentes(f.getAbsolutePath(), Integer.parseInt(v[2]));                        
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        }   
    }
    
    /**
    * Método que permite ejecutar los comandos:
    * analizadorTexto -l [nombre del archivo]
    * analizadorTexto -s [nombre del archivo]
    * analizadorTexto -l [número de palabras comunes] [nombre del archivo]
    * analizadorTexto -s [número de palabras comunes] [nombre del archivo]
    * @param comando comando
    * @param f archivo
    **/
    public static void obtenerCadenaLargaCortaExp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron1 = Pattern.compile("analizadorTexto -l " + f.getName());
            Pattern patron2 = Pattern.compile("analizadorTexto -l " + v[2] +" "+f.getName());
            Pattern patron3 = Pattern.compile("analizadorTexto -s " + f.getName());
            Pattern patron4 = Pattern.compile("analizadorTexto -s " + v[2] +" "+f.getName());
            Matcher encaja1 = patron1.matcher(comando);
            Matcher encaja2 = patron2.matcher(comando);
            Matcher encaja3 = patron3.matcher(comando);
            Matcher encaja4 = patron4.matcher(comando);
            if(encaja1.find()){
                ControladorMetodos.obtenerCadenaL(f.getAbsolutePath());
            }if((encaja2.find() && Integer.parseInt(String.valueOf(v[2]))>0)){
                ControladorMetodos.obtenerNCadenasLargas(f.getAbsolutePath(), Integer.parseInt(v[2]));                              
            }if(encaja3.find())
                ControladorMetodos.obtenerCadenaC(f.getAbsolutePath());
            if((encaja4.find() && Integer.parseInt(String.valueOf(v[2]))>0)){
                ControladorMetodos.obtenerNCadenasCortas(f.getAbsolutePath(), Integer.parseInt(v[2]));         
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        }   
    }
    
    public static void permutacion1_2Exp(String comando, File f){        
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -d -c " + v[3] +" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -d "+v[2]+" -c " + v[4] +" "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find())
                ControladorMetodos.permutacion1(f.getAbsolutePath(), v[3]);
            if(encaja2.find() && Integer.parseInt(v[2])>0)
                ControladorMetodos.permutacion2(f.getAbsolutePath(), v[4], Integer.parseInt(v[2]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }         
    }
    
    public static void permutacion3_4Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -l -c " + v[3] +" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -l "+v[2]+" -c " + v[4] +" "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find())
                ControladorMetodos.permutacion3(f.getAbsolutePath(), v[3]);  
            if(encaja2.find() && Integer.parseInt(v[2])>0)
                ControladorMetodos.permutacion4(f.getAbsolutePath(), v[4], Integer.parseInt(v[2]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    
    public static void permutacion5_6Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -s -c " + v[3] +" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -s "+v[2]+" -c " + v[4] +" "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find())
                ControladorMetodos.permutacion5(f.getAbsolutePath(), v[4]);  
            if(encaja2.find() && Integer.parseInt(v[2])>0)
                ControladorMetodos.permutacion6(f.getAbsolutePath(), v[4], Integer.parseInt(v[2]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    
    public static void permutacion7_8Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -l -d "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -l " +v[2]+ " -d "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find())
                ControladorMetodos.permutacion7(f.getAbsolutePath());  
            if(encaja2.find() && Integer.parseInt(v[2])>0)                
                ControladorMetodos.permutacion8(f.getAbsolutePath(),Integer.parseInt(v[2]));            
            
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    
    public static void permutacion9_10Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -s -d "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -s " +v[2]+ " -d "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find())
                ControladorMetodos.permutacion9(f.getAbsolutePath());  
            if(encaja2.find() && Integer.parseInt(v[2])>0)                
                ControladorMetodos.permutacion10(f.getAbsolutePath(),Integer.parseInt(v[2]));            
            
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    public static void permutacion11_12Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -l -d "+v[3]+" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -l " +v[2]+ " -d "+v[4]+" "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find() && Integer.parseInt(v[3])>0)
                ControladorMetodos.permutacion11(f.getAbsolutePath(),Integer.parseInt(v[3]));  
            if(encaja2.find() && Integer.parseInt(v[2])>0 && Integer.parseInt(v[4])>0)                
                ControladorMetodos.permutacion12(f.getAbsolutePath(),Integer.parseInt(v[2]), Integer.parseInt(v[4]));            
            
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    
    public static void permutacion13_14Exp(String comando, File f){
        String[] v = null;
        try {
            v = comando.split(" ");            
            Pattern patron = Pattern.compile("analizadorTexto -s -d "+v[3]+" "+ f.getName());
            Matcher encaja = patron.matcher(comando);
            Pattern patron2 = Pattern.compile("analizadorTexto -s " +v[2]+ " -d "+v[4]+" "+ f.getName());
            Matcher encaja2 = patron2.matcher(comando);
            if(encaja.find() && Integer.parseInt(v[3])>0)
                ControladorMetodos.permutacion13(f.getAbsolutePath(),Integer.parseInt(v[3]));  
            if(encaja2.find() && Integer.parseInt(v[2])>0 && Integer.parseInt(v[4])>0)                
                ControladorMetodos.permutacion14(f.getAbsolutePath(),Integer.parseInt(v[2]), Integer.parseInt(v[4]));            
            
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
        }     
    }
    
}
