package cecar.edu.controlador;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


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
* Clase que permite ejecutar métodos de manipulación de listas dinámicas una vez se carga el archivo.
* @see ArrayList generarResumen(String dir)
* @see ArrayList contarCadenaRepetida(String dir, String cad)
* @see ArrayList contarFrecuenciaCadena
**/
public class ControladorMetodos {
    
    public static boolean bandera;
    /**
    * Método que permite generar la linea más larga a partir de un archivo de texto.    
     * @param dir dirección del archivo
     * @return ArrayList de String
    **/
    public static ArrayList<String> generarResumen(String dir){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMayor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()>cadMayor.length()){
                cadMayor = lista.get(i);
            }
        }            
        res.add(cadMayor);         
        ControladorArchivos.guardarArchivo(res, "archivo de salida - Resumen");
        return res;
    }
    
    /**
    * Método que permite generar las palabras más frecuentes a partir de un archivo de texto.
     * @param dir dirección del archivo
     * @param cad cadena buscada
     * @return ArrayList de String
    **/
    public static ArrayList<String> contarCadenaRepetida(String dir, String cad){
        int contador = 0;
        StringTokenizer st=null;
        ArrayList<String> lineas = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();       
        for (String l : lineas) {
            st = new StringTokenizer(l);
            while(st.hasMoreTokens()){
                if(st.nextElement().equals(cad)){
                    contador++;
                }
            }
            res.add(contador + " " + l+"\n");            
            contador = 0;
        }       
        ControladorArchivos.guardarArchivo(res, "Archivo de salida - conteo de cadena");
        lineas=null;
        return res;
    }
    
    /**
    * Método que permite generar la palabra más frecuente a partir de un archivo de texto.
     * @param dir dirección del archivo
     * @return ArrayList de String
    **/    
    public static ArrayList<String> generarLaPalabraMasFrecuente(String dir){
        ArrayList<String> lineas = ControladorArchivos.leerArchivo(dir);
        Map<Integer,String> res = new HashMap<>();            
        ArrayList<String> aux = new ArrayList<>();    
        ArrayList<String> aux1 = new ArrayList<>(); 
        int contador = 0;
        StringTokenizer st;               
        String cadena = "";
        
        for (int i = 0; i < lineas.size(); i++) {
            cadena+=lineas.get(i)+" ";
        }        

        st = new StringTokenizer(cadena);

        while(st.hasMoreTokens()){
            aux.add(st.nextToken());
        }                                        
        
        aux.forEach((r) -> {           
            res.put(Collections.frequency(aux, r),r);            
        });

        Map<Integer, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());

        reverseSortedMap.putAll(res);

        reverseSortedMap.entrySet().forEach(a->{
            if(a.getKey()>1){
                aux1.add(a.getValue());                
            }
        });       
        
        try {
            cadena="";
            cadena = aux1.get(0);
            aux1.removeAll(aux1);
            aux1.add(cadena);
            ControladorArchivos.guardarArchivo(aux1, "Archivo de salida - Palabra más frecuente");
        } catch (Exception e) {
        }
                                           
        return aux1;
    }
    
    /**
    * Método que permite generar la palabra más frecuente a partir de un archivo de texto.
     * @param dir dirección del archivo
     * @param n número de palabras frecuentes a solicitar
     * @return ArrayList de String
    **/   
    public static ArrayList<String> generarPalabrasFrecuentes(String dir, int n){
        
        ArrayList<String> lineas = ControladorArchivos.leerArchivo(dir);
        Map<Integer,String> res = new HashMap<>();            
        ArrayList<String> aux = new ArrayList<>();    
        ArrayList<String> aux1 = new ArrayList<>(); 
        int contador = 0;
        StringTokenizer st;               
        String cadena = "";
        
        for (int i = 0; i < lineas.size(); i++) {
            cadena+=lineas.get(i)+" ";
        }        

        st = new StringTokenizer(cadena);

        while(st.hasMoreTokens()){
             aux.add(st.nextToken());
        }                                

        aux.forEach((r) -> {           
             res.put(Collections.frequency(aux, r),r);            
        });

        Map<Integer, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());

        reverseSortedMap.putAll(res);

        reverseSortedMap.entrySet().forEach(a->{
            if(a.getKey()>1){
                aux1.add(a.getValue());
            }
        });
        cadena="";
        for(int i=0; i<n; i++){
            try {                
                cadena += aux1.get(i) +" ";
            } catch (Exception e) {                
            }                        
         }
        try {
            cadena = cadena.substring(0, cadena.length()-1);        
            aux1.removeAll(aux1);
            aux1.add(cadena);
            ControladorArchivos.guardarArchivo(aux1, "Archivo de salida - Palabras frecuentes");
        } catch (Exception e) {
        }
               
        return aux1;
    }
    
    /**
    * Método que permite generar la cadena más larga a partir de un
    * archivo de texto, sin indicación.    
    * @param dir dirección del archivo
    * @return ArrayList de String
    **/
    public static ArrayList<String> obtenerCadenaL(String dir){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMayor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()>cadMayor.length()){
                cadMayor = lista.get(i);
            }
        }            
        res.add(cadMayor);         
        ControladorArchivos.guardarArchivo(res, "archivo de salida - Cadena más larga");
        return res;        
    }
    
    /**
    * Método que permite generar la cadena más corta a partir de un
    * archivo de texto, sin indicación.    
    * @param dir dirección del archivo
    * @return ArrayList de String
    **/
    public static ArrayList<String> obtenerCadenaC(String dir){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMenor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()<cadMenor.length()){
                cadMenor = lista.get(i);
            }
        }            
        res.add(cadMenor);         
        ControladorArchivos.guardarArchivo(res, "archivo de salida - Cadena más corta");
        return res;        
    }
    
    /**
    * Método que permite generar el número de cadenas más largas a partir de un
    * archivo de texto.    
    * @param dir dirección del archivo
    * @param n cantidad de cadenas largas
    * @return ArrayList de String
    **/
    public static ArrayList<String> obtenerNCadenasLargas(String dir, int n){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> aux1 = new ArrayList<>();        
        SortedMap<Integer, String> tree = new TreeMap(Collections.reverseOrder());
        
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            tree.put(lista.get(i).length(), lista.get(i));
        }
        
        Integer min = Collections.min(tree.keySet());                                                              
        
        tree.entrySet().forEach(s->{            
            if(s.getKey()>min){               
                aux.add(s.getValue());                  
            }
        });  
        
        for (int i = 0; i <n; i++) {
            try {
                aux1.add(aux.get(i)+"\n");
            } catch (Exception e) {
            }
        }
        
        ControladorArchivos.guardarArchivo(aux1, "Archivo de salida - Nro. de cadenas más largas");
        return aux1;
    }
    
    /**
    * Método que permite generar el número de cadenas más cortas a partir de un
    * archivo de texto.    
    * @param dir dirección del archivo
    * @param n cantidad de cadenas cortas
    * @return ArrayList de String
    **/
    public static ArrayList<String> obtenerNCadenasCortas(String dir, int n){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> aux1 = new ArrayList<>();        
        SortedMap<Integer, String> tree = new TreeMap<>();
        
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            tree.put(lista.get(i).length(), lista.get(i));
        }
        
        Integer max = Collections.max(tree.keySet());                                        
       
        tree.entrySet().forEach(s->{            
            if(s.getKey()<max){               
                aux.add(s.getValue());                  
            }
        });         
        
        for (int i = 0; i <n; i++) {
            try {
                aux1.add(aux.get(i)+"\n");
            } catch (Exception e) {
            }
        }
                
        ControladorArchivos.guardarArchivo(aux1, "Archivo de salida - Nro. de cadenas más largas");
        return aux1;
    }    
    
    
    //PERMUTACIÓN 1     
    //analizadorTexto -d -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion1(String dir, String cad){
        ArrayList<String> lineas = ControladorArchivos.leerArchivo(dir);
        Map<Integer,String> res = new HashMap<>();            
        ArrayList<String> aux = new ArrayList<>();    
        ArrayList<String> aux1 = new ArrayList<>(); 
        int contador = 0;
        StringTokenizer st;               
        String cadena = "";
        
        for (int i = 0; i < lineas.size(); i++) {
            cadena+=lineas.get(i)+" ";
        }        

        st = new StringTokenizer(cadena);

        while(st.hasMoreTokens()){
            aux.add(st.nextToken());
        }                                        
        
        aux.forEach((r) -> {           
            res.put(Collections.frequency(aux, r),r);            
        });

        Map<Integer, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());

        reverseSortedMap.putAll(res);

        reverseSortedMap.entrySet().forEach(a->{
            if(a.getKey()>1){
                aux1.add(a.getValue());                
            }
        });       
        
        try {
            cadena="";
            cadena = aux1.get(0);
            aux1.removeAll(aux1);
            aux1.add(cadena);
            ArrayList<String> aux2 = new ArrayList<>();            
            contador=0;
            for (String s : aux1) {
                st = new StringTokenizer(s);
                while(st.hasMoreTokens()){
                    if(st.nextElement().equals(cad)){
                        contador++;
                    }
                    aux2.add(contador + " " + s);                    
                }
            }
            ControladorArchivos.guardarArchivo(aux2, "Archivo de salida - Permutacion1");
        } catch (Exception e) {
        }
                                           
        return aux1;
    }
    
    //PERMUTACIÓN 2    
    //analizadorTexto -d [numero] -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion2(String dir, String cad, int n){
        ArrayList<String> lineas = ControladorArchivos.leerArchivo(dir);
        Map<Integer,String> res = new HashMap<>();            
        ArrayList<String> aux = new ArrayList<>();    
        ArrayList<String> aux1 = new ArrayList<>();         
        ArrayList<String> aux2 = new ArrayList<>();  
        StringTokenizer st;               
        String cadena = "";
        
        for (int i = 0; i < lineas.size(); i++) {
            cadena+=lineas.get(i)+" ";
        }        

        st = new StringTokenizer(cadena);

        while(st.hasMoreTokens()){
             aux.add(st.nextToken());
        }                                

        aux.forEach((r) -> {           
             res.put(Collections.frequency(aux, r),r);            
        });

        Map<Integer, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());

        reverseSortedMap.putAll(res);

        reverseSortedMap.entrySet().forEach(a->{
            if(a.getKey()>1){
                aux1.add(a.getValue());
            }
        });
        cadena="";
        for(int i=0; i<n; i++){
            try {                
                cadena += aux1.get(i) +" ";
            } catch (Exception e) {                
            }                        
         }
        try {
            cadena = cadena.substring(0, cadena.length()-1); 
            
            aux1.removeAll(aux1);
            aux1.add(cadena);
            int c=0;
            st = null;
            
            for (String s : aux1) {
                st = new StringTokenizer(s);
                while(st.hasMoreTokens()){
                    if(st.nextElement().equals(cad)){
                        c++;
                    }
                }
                aux2.add(c + " " + s + "\n");
                c=0;
            }
            ControladorArchivos.guardarArchivo(aux2, "Archivo de salida - Permutacion2");
        } catch (Exception e) {
        }
               
        return aux1;
    }
    
    //PERMUTACIÓN 3
    //analizadorTexto -l -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion3(String dir, String cad){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMayor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()>cadMayor.length()){
                cadMayor = lista.get(i);
            }
        }            
        res.add(cadMayor);   
        int c=0;
        StringTokenizer st = null;
        ArrayList<String> aux = new ArrayList<>();
        for (String r : res) {            
            st = new StringTokenizer(r);
            while(st.hasMoreTokens()){
                if(st.nextElement().equals(cad)){
                    c++;
                }                
            }
            aux.add(c + " " + r+"\n");
            c=0;
        }
        ControladorArchivos.guardarArchivo(aux, "archivo de salida - Permutacion3");
        return res;   
    }
    
    //PERMUTACIÓN 4
    //analizadorTexto -l [numero] -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion4(String dir, String cad, int n){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> aux1 = new ArrayList<>();        
        SortedMap<Integer, String> tree = new TreeMap(Collections.reverseOrder());
        
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            tree.put(lista.get(i).length(), lista.get(i));
        }
        
        Integer min = Collections.min(tree.keySet());                                                              
        
        tree.entrySet().forEach(s->{            
            if(s.getKey()>min){               
                aux.add(s.getValue());                  
            }
        });  
        
        for (int i = 0; i <n; i++) {
            try {
                aux1.add(aux.get(i)+"\n");
            } catch (Exception e) {
            }
        }
        
        int c = 0;
        StringTokenizer st = null;
        ArrayList<String> aux2 = new ArrayList<>();
        for (String s : aux1) {
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                if(st.nextElement().equals(cad)){
                    c++;
                }
            }
            aux2.add(c + " " + s);            
            c = 0;
            
        }
        
        ControladorArchivos.guardarArchivo(aux2, "Archivo de salida - permutacion4");
        return aux1;
    }
    
    //PERMUTACIÓN 5
    //analizadorTexto -s -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion5(String dir, String cad){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMenor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()<cadMenor.length()){
                cadMenor = lista.get(i);
            }
        }            
        res.add(cadMenor);  
        int c=0;
        StringTokenizer st =null;
        ArrayList<String> aux = new ArrayList<>();
        for (String r : res) {
            st = new StringTokenizer(r);
            while(st.hasMoreTokens()){
                if(st.nextElement().equals(cad)){
                    c++;
                }
            }
            aux.add(c+" "+r+"\n");
            c=0;
        }
        ControladorArchivos.guardarArchivo(aux, "Permutacion5");
        return aux;
    }
    
    //PERMUTACIÓN 6
    //analizadorTexto -s [numero] -c <palabra> [nombre archivo.txt]
    public static ArrayList<String> permutacion6(String dir, String cad, int n){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> aux1 = new ArrayList<>();        
        SortedMap<Integer, String> tree = new TreeMap<>();
        
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            tree.put(lista.get(i).length(), lista.get(i));
        }
        
        Integer max = Collections.max(tree.keySet());                                                              
        
        tree.entrySet().forEach(s->{            
            if(s.getKey()<max){               
                aux.add(s.getValue());                  
            }
        });  
        
        for (int i = 0; i <n; i++) {
            try {
                aux1.add(aux.get(i)+"\n");
            } catch (Exception e) {
            }
        }
        
        int c = 0;
        StringTokenizer st = null;
        ArrayList<String> aux2 = new ArrayList<>();
        for (String s : aux1) {
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                if(st.nextElement().equals(cad)){
                    c++;
                }
            }
            aux2.add(c + " " + s);            
            c = 0;
            
        }
        
        ControladorArchivos.guardarArchivo(aux2, "Archivo de salida - permutacion6");
        return aux1;
    }
    
    //PERMUTACIÓN 7
    //analizadorTexto -l -d [nombre archivo.txt]
    public static ArrayList<String> permutacion7(String dir){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> res = new ArrayList<>();
        String cadMayor=lista.get(0);        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).length()>cadMayor.length()){
                cadMayor = lista.get(i);
            }
        }            
        res.add(cadMayor);  
        Map<Integer,String> map = new HashMap<>();
        String cad="";
        for (int i = 0; i < res.size(); i++) {
            cad+=res.get(i)+" ";            
        }
        StringTokenizer st = new StringTokenizer(cad);
        ArrayList<String> aux=new ArrayList<>();
        ArrayList<String> aux2=new ArrayList<>();
        while(st.hasMoreTokens()){
            aux.add(st.nextToken());
        }
        
        aux.forEach(s->{
            map.put(Collections.frequency(aux, s),s);
        });
        
        Map<Integer,String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        
        reverseSortedMap.putAll(map);
        
        reverseSortedMap.entrySet().forEach(a->{
            if(a.getKey()>1){
                aux2.add(a.getValue());                
            }
        });       
        
        try {
            cad="";
            cad = aux2.get(0);
            aux2.removeAll(aux2);
            aux2.add(cad);
            ControladorArchivos.guardarArchivo(aux2, "Archivo de salida - Permutación7");
        } catch (Exception e) {
        }                
        return res;  
    }
    
    //PERMUTACIÓN 8
    //analizadorTexto -l [numero] -d [nombre archivo.txt]
    public static ArrayList<String> permutacion8(String dir, int n){
        ArrayList<String> lista = ControladorArchivos.leerArchivo(dir);
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> aux1 = new ArrayList<>();        
        SortedMap<Integer, String> tree = new TreeMap(Collections.reverseOrder());
        
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            tree.put(lista.get(i).length(), lista.get(i));
        }
        
        Integer min = Collections.min(tree.keySet());                                                              
        
        tree.entrySet().forEach(s->{            
            if(s.getKey()>min){               
                aux.add(s.getValue());                  
            }
        });  
        
        for (int i = 0; i <n; i++) {
            try {
                aux1.add(aux.get(i)+"\n");
            } catch (Exception e) {
            }
        }
        String cad="";
        ArrayList<String> aux3 = new ArrayList<>();
        ArrayList<String> aux4 = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        for(int i=0; i<aux1.size(); i++){
            cad+=aux1.get(i)+" ";
        }
        StringTokenizer st = new StringTokenizer(cad);
        while(st.hasMoreTokens()){
            aux3.add(st.nextToken());            
        }
        aux3.forEach((r)->{
            System.out.println(r);
            map.put(Collections.frequency(aux3, r), r);
        });
        
        Map<Integer,String> reverseSortedMap = new TreeMap(Collections.reverseOrder());
        reverseSortedMap.putAll(map);
        reverseSortedMap.entrySet().forEach(s->{
            if(s.getKey()>1){
                aux4.add(s.getValue());                               
            }
        });
        try {
            cad="";
            cad=aux4.get(0);
            aux4.removeAll(aux4);
            aux4.add(cad);
            ControladorArchivos.guardarArchivo(aux4, "Archivo de salida - Permutacion8");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return aux1;
    }
}
