package cecar.edu.vista;

import cecar.edu.controlador.ControladorArchivos;
import cecar.edu.controlador.ControladorPatron;
import java.io.File;
import java.util.Scanner;

/**
 * Clase: Cli
 * 
 * @version: 0.1
 *  
 * @since: 24/08/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Frank Camilo Atencio Loreth
 * 
 * Copyrigth: CECAR
 */


public class Cli {
    public static void main(String argumentos[]){                
        Scanner t = new Scanner(System.in);
        String entrada="";
                
        File a = ControladorArchivos.cargarArchivo();             
        do{
            try {
                System.out.print("\n"+"C:"+File.separator+"Users"+File.separator+System.getProperty("user.name")+">"); entrada = t.nextLine();                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            ControladorPatron.generarResumenExp(entrada, a);
            ControladorPatron.contadorPalabrasExp(entrada, a);
            ControladorPatron.obtenerpalabrasComunesExp(entrada, a);
            ControladorPatron.obtenerCadenaLargaCortaExp(entrada, a);      
            ControladorPatron.permutacion1_2Exp(entrada, a);
            ControladorPatron.permutacion3_4Exp(entrada, a);
            ControladorPatron.permutacion5_6Exp(entrada, a);
            ControladorPatron.permutacion7_8Exp(entrada, a);
        }while(!"exit".equalsIgnoreCase(entrada));        
    }
}
