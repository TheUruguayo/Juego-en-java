/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Memory {
    private HashMap<String, Tema> temas = new HashMap<>();
    private ArrayList<Pregunta> arraypreguntas = new ArrayList<Pregunta>();
    private int puntos=0;
    private String[][] preguntaOresputa= new String[3][4]; //matriz
    private String temasElegidosString="";


   
    public Memory(HashMap<String, Tema> unMapa){
      this.temas=unMapa;
      //this.azar(2);
      if (this.minimo(unMapa)){ //pedis que halla un minimo
        this.arrayDePreguntas();
      }
    }
      
    public boolean minimo(HashMap<String, Tema> unMapa){
        int count=0;
        for (String i : unMapa.keySet()) {
            count+=unMapa.get(i).Cantpreguntas();
        }
        return (count>=6);
    }    
    
    //Set´s y Get´s
    public HashMap<String, Tema> getTemas() {
        return temas;
    }

   
    public void setTemas(HashMap<String, Tema> temas) {
        this.temas = temas;
    }

    
    public ArrayList<Pregunta> getArraypreguntas() {
        return arraypreguntas;
    }

   
    public void setArraypreguntas(ArrayList<Pregunta> arraypreguntas) {
        this.arraypreguntas = arraypreguntas;
    }
    
    public int getPuntos() {
        return puntos;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public String[][] getPreguntaOresputa() {
        return preguntaOresputa;
    }
 
    public void setPreguntaOresputa(String[][] preguntaOresputa) {
        this.setPreguntaOresputa(preguntaOresputa);
    }
 
    public String getTemasElegidosString() {
        return temasElegidosString;
    }

    public void setTemasElegidosString(String temasElegidosString) {
        this.temasElegidosString = temasElegidosString;
    }
    
    public String[][] matrizPregutnasRespuestas(){//este metodo garantiza preguntas y respuestas en lugares siempre disintos
        String[][] matriz= new String[3][4];          //devuelve y guarda las respuestas y formaulas en lugares aleatorios
    
        ArrayList<Integer> random = new ArrayList<>();//lleno el array con enteros
    
        for (int x=0;x<12;x++){
            random.add(x);
        }
        Collections.shuffle(random);             //ahora quedaron en deshorden   
        for(int i=0;i<6;i++){                        //numeros al azar sin repeticion
                                                 //guardas la respusta y la pregutna al mismo tienmpo en lugares distintos
            matriz[random.get(i)/4][random.get(i)%4]=this.getArraypreguntas().get(i).getFormula(); 
            matriz[(random.get(i+6))/4][(random.get(i+6))%4]=this.getArraypreguntas().get(i).getRespuesta();
            this.getPreguntaOresputa()[random.get(i)/4][random.get(i)%4]="PREG";
            this.getPreguntaOresputa()[(random.get(i+6))/4][(random.get(i+6))%4]="RES"; 
        }
        return matriz;
    }
    
   public  void arrayDePreguntas(){
        int y=0;//indice para el array   
        this.getTemas();
        for (String i : this.getTemas().keySet()) {//reccorre los temas
            this.setTemasElegidosString(this.getTemasElegidosString()+this.getTemas().get(i).getNombre()+" "+this.getTemas().get(i).getDescripcion()+"; ");
            for (String b : this.getTemas().get(i).getPreguntas().keySet()){// las preguntas
                this.getArraypreguntas().add(y,this.getTemas().get(i).getPreguntas().get(b));            
                System.out.println(this.getArraypreguntas().get(y).getFormula());
                y++;
            }
        }
        Collections.shuffle(this.getArraypreguntas()); 
    }   
    
    public void azar(int unaCantidad){//quita esta cantidad de pregutnas
        int count=unaCantidad;
        int random=4;
        ArrayList<String>aux = new ArrayList<String>();        
        for (String i : this.getTemas().keySet()) {
            for (String b : this.getTemas().get(i).getPreguntas().keySet()) {
                if (random%2==0 && (this.getTemas().get(i).getPreguntas().size())-count>0 && count>0){
                    aux.add(this.getTemas().get(i).getPreguntas().get(b).getFormula());
                }
                count--;
            }//for
            for(int x=0;x<aux.size();x++){
                this.getTemas().get(i).getPreguntas().remove(aux.get(0));
            }  
            count=0;
        }//endfor
     }

    public int puntos(String unArray[]){
        int salida=-10;
        for (int i=0;i<this.getArraypreguntas().size();i++){     
            if (this.getArraypreguntas().get(i).getFormula().compareTo(unArray[0])==0){ 
                if(this.getArraypreguntas().get(i).getRespuesta().compareTo(unArray[1])==0){
                    salida=50;
                }
            }else if (this.getArraypreguntas().get(i).getFormula().compareTo(unArray[1])==0){
                if(this.getArraypreguntas().get(i).getRespuesta().compareTo(unArray[0])==0){
                    salida=50;
                }
            }
        }   
      
        salida=this.getPuntos()+salida;
        if (salida<0){
          this.setPuntos(0);
        }else 
            {this.setPuntos(salida);}
        return  (this.getPuntos());
    }
    
}

    
    

