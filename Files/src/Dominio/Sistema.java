/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;


import claseformater.ArchivoGrabacion;
import java.io.Serializable;
import java.util.HashMap;
import claseformater.ArchivoLectura;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Sistema implements Serializable{
    private int tPreguntas=0;
    private String modi="";
    private HashMap<String, Tema> temas = new HashMap<>(); //transient si no quiero serializar
   
  

    //Set´s y Get´s
    public HashMap<String, Tema> getTemas() {
        return temas;
    }
    
    public void setTemas(HashMap<String, Tema> unaLista) {
        this.temas = unaLista;
    }
    
    public int getTpreguntas() {
        return tPreguntas;
    }

    public void setTpreguntas(int tpreguntas) {
        this.tPreguntas = tpreguntas;
    }


    public String getModi() {
        return modi;
    }


    public void setModi(String modi) {
        this.modi = modi;
    }
    
   public int[] agregarTema(String[] unArray){
                                     // chequea que las lineas no esten vacias
                                     //si no estan vacias procede a crear o modificar 
                                    //arrar[0] es tema array 1 es pregunta y array 3 respuesta
        int[] aux= new int[3];
       
        if (unArray[0].length()!=0 && unArray[1].length()!=0 && unArray[2].length()!=0){
            Tema t1;
            //busco, no esta agrego
            //busco y esta llamo al que agrega
            if (this.getTemas().get(unArray[0])!=null){
            //encontre el tema, busco la pregutna
                int[] aux2=this.getTemas().get(unArray[0]).agregarPregunta( unArray[1], unArray[2]);
                aux[1]=aux2[1];
                aux[2]=aux2[2];
            } else {
                //no encontre el tema, lo agrego
                t1=new Tema(unArray[0],unArray[1],unArray[2]);
                this.getTemas().put(t1.getNombre(), t1);
                aux[1]=1;//nueva
           } 
        }else {
            aux[0]=1;//descartada
        }
        return aux; 
    }
 
   
   public void cargarPreguntas(String unString){ 
        String salida="";
        ArchivoLectura lec= new ArchivoLectura(unString);
        String[] s1= new String[3];
        int[] aux=new int[3]; 
        int[] aux2;
        int count=0;
        
        while (lec.hayMasLineas()){
            s1[count]=lec.linea();
            count++;
            if (count==3){
                count=0;
                aux2= this.agregarTema(s1);
                aux[0]+=aux2[0];
                aux[1]+=aux2[1];
                aux[2]+=aux2[2];
            } 
            System.out.println(lec.linea());
        }
        if(count>0){
            aux[0]++;
        }
        this.setModi("Descartadas "+aux[0]+ " Nuevas "+aux[1]+" Modificadas "+aux[2]);
    }
   
   
   public void guardarPreguntas(String unString){
        ArchivoGrabacion sal= new ArchivoGrabacion (unString);

        for(String i:this.getTemas().keySet()){                          //busca los TEmas 
            for(String b:this.getTemas().get(i).getPreguntas().keySet()){//se para en el tema, y buscas sus pregutnas
                sal.grabarLinea(this.getTemas().get(i).getNombre());    
                sal.grabarLinea(this.getTemas().get(i).getPreguntas().get(b).getFormula());
                sal.grabarLinea(this.getTemas().get(i).getPreguntas().get(b).getRespuesta());

            }
       }
       sal.cerrar();
       }
   
    public String mostrarTemas(){//simplemente para mostrar en formato string todas las preguntas y respuestas delsistema
        String salida="";
        for (String i : this.getTemas().keySet()) {
        
            System.out.println("Name: " + i + " Descripcion: " + this.getTemas().get(i).getDescripcion());
            salida+=("Name: " + i + " Descripcion: " + this.getTemas().get(i).getDescripcion())+("\n");
            for (String b : this.getTemas().get(i).getPreguntas().keySet()) {
                System.out.println("esto: " + b + " Descripcion: " + this.getTemas().get(i).getPreguntas().get(b).getRespuesta());
                salida+=("esto: " + b + " Descripcion: " + this.getTemas().get(i).getPreguntas().get(b).getRespuesta())+("\n");
      
            }
        }
        return salida;
    }
   
    public String[] temasAstring(){
        return(this.getTemas().keySet().toArray(new String[this.getTemas().size()]));//combierte a arrray de string 
    }
   
    public int totalPreguntas(HashMap<String, Tema> unHashMap){
        int aux=0;   
        for (String i:unHashMap.keySet()){
           aux+=unHashMap.get(i).getPreguntas().size();
        }
        return aux;
    }
   
    public String[] preguntasAstring(){
       
       String[] salida=new String[this.totalPreguntas(this.getTemas())];
       int indice=0;
       
       for(String i: this.getTemas().keySet()){
          String[] aux= this.getTemas().get(i).getPreguntas().keySet().toArray(new String[this.getTemas().get(i).getPreguntas().size()]);
          System.arraycopy(aux, 0, salida, indice, aux.length);
          indice+=this.getTemas().get(i).getPreguntas().size();
        }
        return salida;  
    }
   
    public Tema buscarTema(String unTema){
        return this.getTemas().get(unTema);
    }
   
 public int[] generarAutomatico(int unaCantidadTemas, int catidadPreguntas  ){
       
        int[] retorno=new int [3];
        int[] auxiliar=new int [3];   
        for(int i=0;i<unaCantidadTemas;i++){
           String[] aux= new String[3];
           aux[0]="T:"+(i+1);
           for (int y=0;y< catidadPreguntas;y++){ 
               aux[1]="T:"+(i+1)+ " P:"+(y+1)+" Texto de P:"+(y+1);
               aux[2]="T:"+(i+1)+ " P:"+ (y+1) +" Respuesta de P:"+(y+1);
               auxiliar=this.agregarTema(aux);
               retorno[0]+=auxiliar[0];                                 //descartada
               retorno[1]+=auxiliar[1];                                 //nueva
               retorno[2]+=auxiliar[2];                                 //modificada
               this.getTemas().get("T:"+(i+1)).setDescripcion("Descripcion de T:"+(i+1));
            }
           if (catidadPreguntas==0){
               this.agregar1solotema("T:"+(i+1), "Descripcion de T:"+(i+1));
           
           }
       }   
       this.setModi("Descartadas "+retorno[0]+ " Nuevas "+retorno[1]+" Modificadas "+retorno[2]);
       System.out.println(getModi());
    return retorno;
    }
    
   public void eliminarPregunta (String unTema, String unaPregunta){
        this.getTemas().get(unTema).getPreguntas().remove(unaPregunta);
    }
   
   public boolean elimarTema (String unTema){
        boolean salida=this.getTemas().get(unTema).Cantpreguntas()==0;
       
        if (this.getTemas().get(unTema).Cantpreguntas()==0){
            this.getTemas().remove(unTema);
        }
        return !salida;
    }
   
   public String agregar1solotema(String unNombre, String unaDescripcion){
        String salida="";
        if (this.getTemas().get(unNombre)!=null){
           salida="El tema ya existe";
        }else {
            Tema t= new Tema(unNombre, unaDescripcion);
            this.getTemas().put(t.getNombre(), t);
            salida="Tema creado correcamente";
        }
       return salida;
   }
   
   public void bitacora(){
    
        String aGrabar=getModi();
        ArchivoGrabacion grab= new ArchivoGrabacion("Bitacora.txt",true);
     
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
   
        grab.grabarLinea(aGrabar+" "+ dtf.format(now));
   
        grab.cerrar();
    
      
    }
   
}