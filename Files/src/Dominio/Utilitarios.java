/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.HashMap;


public abstract class Utilitarios {
    
    public static void guardarSistema(Sistema unContenido, String unaDir) throws IOException{  
        FileOutputStream archivo =new FileOutputStream (unaDir);
        try (ObjectOutputStream datos = new  ObjectOutputStream(archivo)) {
             datos.writeObject(unContenido);
        } catch (IOException e){
            System.out.println("e");
        }
    }
   
public static Sistema cargarSistema(String unaDir) throws IOException, ClassNotFoundException,FileNotFoundException{      
       Sistema s1 = null;
        try (FileInputStream archivo =new FileInputStream (unaDir)){
            try (ObjectInputStream datos = new  ObjectInputStream(archivo)) {
            
             s1 = (Sistema) datos.readObject();
        }  catch (IOException e){
            System.out.println("e");
        }catch(ClassNotFoundException a){
            System.out.println("a");
         
        }
       }catch(FileNotFoundException b){
            System.out.println("No hay elementos serializados");
       }
        
        return s1;
    }
    
    public static String[] temasAstring( HashMap<String, Tema> unosTemas){
        return(unosTemas.keySet().toArray(new String[unosTemas.size()]));
   }
    
    
     
}