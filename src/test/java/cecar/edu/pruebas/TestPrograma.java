package cecar.edu.pruebas;


import cecar.edu.controlador.ControladorMetodos;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase: ControladorMetodos
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
* Clase que permite ejecutar métodos para realizar pruebas sobre el código.
* @see public static ArrayList generarResumen(String dir)
* @see public static ArrayList contarCadenaRepetida(String dir, String cad)
* @see public static ArrayList contarFrecuenciaCadena
* @see public void testObtenerCadenaLargaCorta()
**/
public class TestPrograma {
    
   final String ruta = System.getProperty("user.dir")+File.separator+"Archivos"+File.separator+"ArchivoTest 2.txt";
   
   @Test
   public void testSinOpcion(){
       String cadena = "perro pajaro pato gato cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo";
       String res = ControladorMetodos.generarResumen(ruta).get(0);       
       assertEquals("Las cadenas no coinciden",res, cadena);
   }
   
   @Test
   public void testContadorPalabras(){
       String cadena = "Guarapo";
       ArrayList<String> lista = new ArrayList<>();
       lista.add("0 perro pajaro pato gato cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo\n");
       lista.add("0 gato perro pez perro vaca cerdo vaca pez pez pez\n");
       lista.add("2 Guarapo leche arroz azucar caldo sopa pescado gato gato gato gato Guarapo\n");
       
       ArrayList<String> res = ControladorMetodos.contarCadenaRepetida(ruta, cadena);
       
       for(int i=0; i<res.size(); i++){
           assertEquals("Las cadenas no coinciden", lista.get(i), res.get(i));
       }      
   }
   
   @Test
   public void testPalabrasComunes(){
       String numero="6";       
       String[] cadenaPrueba = {"cerdo","cerdo gato pez perro Guarapo"};
       ArrayList<String>res;
       if(numero.equals("")){
           res=null;
           res = ControladorMetodos.generarLaPalabraMasFrecuente(ruta);           
           assertEquals("Las cadenas no coinciden",res.get(0), cadenaPrueba[0]);
       }else if(Integer.parseInt(numero)>0){
           res=null;
           res = ControladorMetodos.generarPalabrasFrecuentes(ruta, Integer.parseInt(numero));
           assertEquals("Las cadenas no coinciden",res.get(0), cadenaPrueba[1]);
       }else
           System.out.println("El número no es entero.");                        
   }
    
   @Test
   public void testObtenerCadenaLargaCorta(){
       String numero="5";
       
       String[] cadenaPrueba = {
           "perro pajaro pato gato cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo",
           "gato perro pez perro vaca cerdo vaca pez pez pez"           
       };
       
       ArrayList<String> listaLarga = new ArrayList<>();
       ArrayList<String> listaCorta = new ArrayList<>();
       ArrayList<String> resLarga, resCorta;
       
       if(numero.equals("")){           
           assertEquals("Las cadenas no coinciden",cadenaPrueba[0], ControladorMetodos.obtenerCadenaL(ruta).get(0));
           assertEquals("Las cadenas no coinciden",cadenaPrueba[1], ControladorMetodos.obtenerCadenaC(ruta).get(0));
           
       }else if(Integer.parseInt(numero)>0){
           resLarga = ControladorMetodos.obtenerNCadenasLargas(ruta, Integer.parseInt(numero));
           resCorta = ControladorMetodos.obtenerNCadenasCortas(ruta, Integer.parseInt(numero));
           
           listaLarga.add("perro pajaro pato gato cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo cerdo\n");
           listaLarga.add("Guarapo leche arroz azucar caldo sopa pescado gato gato gato gato Guarapo\n");                                                                            
           
           for(int i=0; i<resLarga.size(); i++){               
                try {
                   assertEquals(
                    "Las cadenas largas no coinciden",
                        resLarga.get(i) ,listaLarga.get(i)                                                         
                    );
               } catch (Exception e) {
               }
           }
           
           listaCorta.add("gato perro pez perro vaca cerdo vaca pez pez pez\n");
           listaCorta.add("Guarapo leche arroz azucar caldo sopa pescado gato gato gato gato Guarapo\n");
           
           for(int i = 0; i < listaCorta.size(); i++)
               try {
                   assertEquals(
                   "Las cadenas cortas no coinciden",
                   listaCorta.get(i),
                   resCorta.get(i)
               );
               } catch (Exception e) {
               }
           
       }else{
           System.out.println("El número no es entero.");
       }
   }
}
