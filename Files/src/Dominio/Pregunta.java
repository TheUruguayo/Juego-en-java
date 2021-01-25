/*
Obligatorio Final:
    -Ignacio Lanzani  (143289)
    -Alejandro Rossi  (195243)
 */
package Dominio;

import java.io.Serializable;

public class Pregunta implements Serializable{
    private String formula="";
    private String respuesta="";
    private String tema="";

    public Pregunta( String unTema, String unaFormula,String unaRespuesta){
    
        this.tema=unTema;
        this.formula=unaFormula;
        this.respuesta=unaRespuesta;
    }
    
    //Set´s y Get´s
    public String getFormula() {
        return formula;
    }

    public void setFormula(String unaFormula) {
        this.formula = unaFormula;
    }

    
    public String getRespuesta() {
        return respuesta;
    }

    
    public void setRespuesta(String unaRespuesta) {
        this.respuesta = unaRespuesta;
    }

    public String getTema() {
        return tema;
    }

    
    public void setTema(String unTema) {
        this.tema = unTema;
    }
    
    
}
