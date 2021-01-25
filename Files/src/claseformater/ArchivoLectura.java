/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package claseformater;

import obligatoriofinal.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

//paquete de archivo lectura y grabacion
public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    //constructor que recibe el nombre
    public ArchivoLectura(String unNombre){
        try{
            in= new Scanner(Paths.get(unNombre));
            
        }catch(IOException e){
            System.out.println("Error de lectura");
            System.exit(1);
        }
    }
    

    //intenta leer y avanza 
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if (in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    //devuelve linea leida, no avanza
    public String linea(){
        return linea;
    }
    public void cerrar(){
        in.close();
    }
    
}

