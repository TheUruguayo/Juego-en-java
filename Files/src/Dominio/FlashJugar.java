/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class FlashJugar {
   private HashMap<String, Tema> temas = new HashMap<>();
   private ArrayList<Tema> arraytemas = new ArrayList<Tema>();
   private ArrayList<Pregunta> arraypreguntas = new ArrayList<Pregunta>();
   private int indice=0;
   
   public FlashJugar( HashMap<String, Tema> unTemas){
        this.temas=unTemas;
        this.azar(2);
        this.arrayDePreguntas();
   }
   
   public FlashJugar(){
   }

   
   //Set´s y Get´s
    public HashMap<String, Tema> getTemas() {
        return temas;
    }

    public void setTemas(HashMap<String, Tema> temas) {
        this.temas = temas;
    }
    
    public void setArraytemas(ArrayList<Tema> arraytemas) {
        this.arraytemas = arraytemas;
    }

    
    public ArrayList<Pregunta> getArraypreguntas() {
        return arraypreguntas;
    }

    
    public void setArraypreguntas(ArrayList<Pregunta> arraypreguntas) {
        this.arraypreguntas = arraypreguntas;
    }

   
    public int getIndice() {
        return indice;
    }

    
    public void setIndice(int indice) {
        this.indice = indice;
    }
       
    public ArrayList<Tema> getArraytemas() {
        return arraytemas;
    }

   
    public void setAux(ArrayList<Tema> aux) {
        this.setArraytemas(aux);
    }
    
    public void azar(int unaCantidad){//quita esta cantidad de pregutnas y selecciona al azar
        int count=unaCantidad;

        ArrayList<Integer> arrayrandom = new ArrayList<>();//lleno el array con enteros

        for (int x=0;x<5;x++){
            arrayrandom.add(x);
            Collections.shuffle( arrayrandom); 
        }

        ArrayList<String>aux = new ArrayList<String>();        
        for (String i : this.getTemas().keySet()) {

            for (String b : this.getTemas().get(i).getPreguntas().keySet()) {

                if (arrayrandom.get(0)%2==0 && (this.getTemas().get(i).getPreguntas().size())-count>0 && count>0){
                    aux.add(this.getTemas().get(i).getPreguntas().get(b).getFormula());
                    Collections.shuffle( arrayrandom); 
                }
             count--;
            }//endfor b
            for(int x=0;x<aux.size();x++){
                this.getTemas().get(i).getPreguntas().remove(aux.get(0));
            }  
            count=0;
        }//endfor

    }
    //temas elegidos dentro del hashmap   
    public String temasEnJuego(){
        String salida="";
        for (String i: this.getTemas().keySet()){
            salida+=this.getTemas().get(i).getNombre()+" "+this.getTemas().get(i).getDescripcion()+"  ";

        }
    return salida;
    }
    //Recorre el hasmap para peder reccorerlo en forma numerica dentro del array list
    public  void arrayDePreguntas(){
        int y=0;//indice para el array   
        this.getTemas();
            for (String i : this.getTemas().keySet()) {//reccorre los temas
                for (String b : this.getTemas().get(i).getPreguntas().keySet()){// las preguntas


                    this.getArraypreguntas().add(y,this.getTemas().get(i).getPreguntas().get(b));

                    System.out.println(this.getArraypreguntas().get(y).getFormula());
                    y++;

                }
            }
            Collections.shuffle(this.getArraypreguntas()); 
    }

    
    //metodo que permite que permite moverse asia la derecha
    public Tema siguienteTema(){
        if (getIndice()<this.getArraytemas().size()){   
            this.setIndice(this.getIndice() + 1);
         
        }
        return this.getArraytemas().get(getIndice());
    }
    
    //metodo que permite que permite moverse asia la izquierada
    public Tema anteriorTema(){
        if (getIndice()>0){    
            this.setIndice(this.getIndice() - 1);
        }
        return this.getArraytemas().get(getIndice());
    }
    
    //tema acual en el array
    public Tema actualTema(){
    
        return this.getArraytemas().get(getIndice());
    }
     
    //devuelve un string de pregunta y respuesta  
    public String[] preguntaRespuesta(){
        String[] salida=new String[2];
        salida[0]=this.getArraypreguntas().get(this.getIndice()).getFormula();
        salida[1]=this.getArraypreguntas().get(this.getIndice()).getRespuesta();
        return salida;
    }//endmetodo
     
    //nos permite avanzar en el array de pregutnas
     //si llegamos al final para o cambia de tema si hay uno
    public String[] siguientePregunta(){
        if (this.getIndice()<this.getArraypreguntas().size()-1) {
            this.setIndice(this.getIndice()+1);
        }
        return this.preguntaRespuesta();
    }
    
    //nos permite ir Hacia atras en el array de preguntas
    //si llegamos al final para o cambia de tema si hay uno
    public String[] anteriorPregunta(){
        if (this.getIndice()>=1) {
            this.setIndice(this.getIndice()-1);
        }    
        return this.preguntaRespuesta();
    }



    

    
}