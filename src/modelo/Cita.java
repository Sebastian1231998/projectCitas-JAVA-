/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario1
 */
public class Cita {
    
    private Integer id_cita;
    private String nombre_mascota;
    private String fecha;
    private String sintomas;
    private Integer peso;
    private String dueno;
    
    
       public Cita() {
     
        this.nombre_mascota = null;
        this.fecha = null;
        this.sintomas = null;
        this.peso = null;
        this.dueno = null;

    }

    public Cita( String nombre_mascota, String fecha, String sintomas, Integer peso, String dueno) {
        this.id_cita =  id_cita;
        this.nombre_mascota = nombre_mascota;
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.peso = peso;
        this.dueno = dueno;
    }
    
     public Cita( Integer id_cita ,String nombre_mascota, String fecha, String sintomas, Integer peso, String dueno) {
        this.id_cita =  id_cita;
        this.nombre_mascota = nombre_mascota;
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.peso = peso;
        this.dueno = dueno;
    }

    

public Integer getId_cita() {
        return id_cita;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public String getFecha() {
        return fecha;
    }

    public String getSintomas() {
        return sintomas;
    }

    public Integer getPeso() {
        return peso;
    }

    public String getDueno() {
        return dueno;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
    
    
    
    
    
 
}
