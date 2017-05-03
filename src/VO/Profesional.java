  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author 416pc01
 */
public class Profesional {
    
    private String nombre;
    private String cedula;
    private String numCel;
    private String rm; // registro medico matricula
    private String especializacion ; // especializacion

    public Profesional(String nombre, String cedula, String numCel, String rm, String especializacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numCel = numCel;
        this.rm = rm;
        this.especializacion = especializacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }
    
}
