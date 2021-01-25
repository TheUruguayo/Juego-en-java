/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package claseformater;

import obligatoriofinal.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;


public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre) {
        try {   
            out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.out.println("error de creacion");
            System.exit(1);
        }
    }

    public ArchivoGrabacion(String unNombre, boolean ext) {
        // si ext es true, extiende el archivo
        try {
            FileWriter f = new FileWriter(unNombre, ext);
            out = new Formatter(f);

        } catch (IOException e) {
            System.out.println("error de creacion");
            System.exit(1);
        }
    }

//pasas una linea y la guarda
    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}

