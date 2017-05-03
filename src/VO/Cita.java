/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author 416pc01
 */
public class Cita {
    private String usuario ;
    private String numId;
    private String tipoId;
    private short edad;
    private String genero;
    private String numTel;
    private String hora;
    private String observacion ;
    private Fecha fecha ;
    private Profesional medico;

    public Cita(String usuario, String numId, String tipoId, short edad, String genero, String numTel, String hora, String observacion, Fecha fecha, Profesional medico) {
        this.usuario = usuario;
        this.numId = numId;
        this.tipoId = tipoId;
        this.edad = edad;
        this.genero = genero;
        this.numTel = numTel;
        this.hora = hora;
        this.observacion = observacion;
        this.fecha = fecha;
        this.medico = medico;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Profesional getMedico() {
        return medico;
    }

    public void setMedico(Profesional medico) {
        this.medico = medico;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}