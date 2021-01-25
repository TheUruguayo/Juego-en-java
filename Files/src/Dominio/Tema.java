/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;

import java.io.Serializable;
import java.util.HashMap;


public class Tema implements Serializable{
   
    private String nombre="";
    private String descripcion="";
    private HashMap<String, Pregunta> preguntas = new HashMap<>();

    public Tema(String unNombre, String unaDescripcion){
    
        this.nombre=unNombre;
        this.descripcion=unaDescripcion;
    
    }
    
    //Get´s  Set´s
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int Cantpreguntas() {
        return getPreguntas().size();
    }

    public String[] preguntasAstring(){
        return(this.getPreguntas().keySet().toArray(new String[this.getPreguntas().size()]));
   
    }
      
    public void setPreguntas(HashMap<String, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
  
    public HashMap<String, Pregunta> getPreguntas() {
        return preguntas;
    } 
    
     
    public Tema(int unNumero){
    
        this.nombre="T:"+unNumero;
        this.descripcion="Descripcion de T"+unNumero;
    }
    
    public void agregarPreguntInt(int unNumero){
        Pregunta p= new Pregunta (this.getNombre(),this.getNombre()+ " P:"+unNumero+" Texto de P "+unNumero," "+this.getNombre()+" P:"+unNumero+" Respuesta de P"+unNumero);
        this.preguntas.put(p.getFormula(), p);
    }
     
    public Tema(String unNombre, String unaPregunta, String unaRespuesta){   
        this.nombre=unNombre;
        Pregunta p= new Pregunta (unNombre,unaPregunta,unaRespuesta);
        this.preguntas.put(p.getFormula(), p);
        this.descripcion="a completar";
    }
    
    //si la pregunta existe, modifica la respuesta
    //si no existe la crea
    public int[] agregarPregunta(String unaPregunta, String unaRespuesta){
        int[] aux=new int[3];
        //si la pregunta existe , se modifica
        Pregunta p= new Pregunta(this.getNombre(),unaPregunta,unaRespuesta);
        
        if (this.getPreguntas().get(unaPregunta)!=null){
            //encontre la pregunte
            this.getPreguntas().get(unaPregunta).setRespuesta(p.getRespuesta());
            aux[2]=1;//modificado
        }else{
            //agrega la nueva pregunta al tema
            
            this.getPreguntas().put(unaPregunta,p);
            aux[1]=1;
        }
        return aux;
    }
    
    public Pregunta buscarPregunta(Pregunta unaPregutna){
        return getPreguntas().get(unaPregutna.getFormula());
    }
    

}
