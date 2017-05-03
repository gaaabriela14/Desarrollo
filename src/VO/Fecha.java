/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author 416pc01
 */
public class Fecha {
    private int dia ;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
   
    
    public boolean equals(Fecha f){
        return this.dia==f.dia &&this.mes==f.mes &&this.anio==f.anio;
    }
    
    public String toString(){
        return this.dia+"/"+this.mes+"/"+this.anio;
    }
    
    
}
